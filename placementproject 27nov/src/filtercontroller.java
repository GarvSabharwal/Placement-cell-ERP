

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import projectbean.*;
import studentmodel.*;

/**
 * Servlet implementation class collegecontroller
 */
@WebServlet("/filtercontroller")
public class filtercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	studentregistration sr;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	Object[][] bookData=new Object[10][12];

    public filtercontroller() {
    	
        super();
    	workbook= new HSSFWorkbook();
    	sheet= workbook.createSheet("Java Books");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		filterdatamodel fdm=new filterdatamodel();
		ArrayList list= fdm.filter();
		int size=list.size();
		for(int i=0;i<size;i++)
        {
			filterbean fb=(filterbean)list.get(i);
			
			bookData[0][0]="EmailID";
			bookData[0][1]="FirstName";
			bookData[0][2]="LastName";
			bookData[0][3]="Course";
			bookData[0][4]="Trade";
			bookData[0][5]="CollegeName";
			bookData[0][6]="Percentage";
			bookData[0][7]="Backlogs";
			bookData[0][8]="Year Of Passing";
			bookData[0][9]="Xth Percentage";
			bookData[0][10]="XII Percentage";
			bookData[0][11]="Diploma Percentage";
			bookData[i+1][0]=fb.getEmailid();
			bookData[i+1][1]=fb.getFirstname();
			bookData[i+1][2]=fb.getLastname();
			bookData[i+1][3]=fb.getGcourse();
			bookData[i+1][4]=fb.getGtrade();
			bookData[i+1][5]=fb.getGcollegename();
			bookData[i+1][6]=fb.getGpercentage();
			bookData[i+1][7]=fb.getGbacklogs();
			bookData[i+1][8]=fb.getGyop();
			bookData[i+1][9]=fb.getTenper();
			bookData[i+1][10]=fb.getTwelveper();
			bookData[i+1][11]=fb.getPercentage();
        }	
		
	
	 
        int rowCount = 0;
         
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);
             
            int columnCount = 0;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
             
        }
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment; filename=aavaBooks.xls");
        
        
        workbook.write(response.getOutputStream()); // Write workbook to response.
        workbook.close();
         
 
		
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

	}
}

