package studentmodel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
 

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.jni.File;

import projectbean.filterbean;

public class filterdatamodel  {

	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	filterbean sr;
public filterdatamodel()  
{
	databaseconnection dbc=new databaseconnection();
	
	con=dbc.databaseconnection();
	
}

public ArrayList filter()throws IOException
{
	list=new ArrayList();
	try {
		ps=con.prepareStatement("select emailid,firstname,lastname,gcourse,gtrade,gcollegename,gpercentage,gbacklogs,gyop,tenper,twelveper,percentage from studentcollegedetails inner join gcolleges  on studentcollegedetails.gcollegeid=gcolleges.gcollegeid inner join studentschooldetails on studentcollegedetails.studentid=studentschooldetails.studentid inner join studentdiplomadetails on studentcollegedetails.studentid=studentdiplomadetails.studentid inner join studentPERSONALdetails on studentcollegedetails.studentid=studentpersonaldetails.studentid inner join registerstudent on studentcollegedetails.studentid=registerstudent.studentid");
		
		
		
		rs=ps.executeQuery();
		while(rs.next())
		{
			
		filterbean fb=new filterbean();
		fb.setEmailid(rs.getString("emailid"));
		fb.setFirstname(rs.getString("firstname"));
		fb.setLastname(rs.getString("lastname"));
		fb.setGcourse(rs.getString("gcourse"));
		fb.setGtrade(rs.getString("gtrade"));
		fb.setGcollegename(rs.getString("gcollegename"));
		fb.setGpercentage(rs.getString("gpercentage"));
		fb.setGbacklogs(rs.getString("gbacklogs"));
		fb.setGyop(rs.getString("gyop"));
		fb.setTenper(rs.getString("tenper"));
		fb.setTwelveper(rs.getString("twelveper"));
		fb.setPercentage(rs.getString("percentage"));
			
		list.add(fb);	
		}
	} catch (Exception e) {
		System.out.print("mai yaha hu"+e.getMessage());
	}
	
	return list;
}


}