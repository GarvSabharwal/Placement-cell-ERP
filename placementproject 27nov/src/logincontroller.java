
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import projectbean.*;
import studentmodel.*;

import java.util.*;

@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	String idcheck2;
	HttpSession loginsession;
	private static final long serialVersionUID = 1L;
       
    public logincontroller() {
        super();
        
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	
		

		String studentid=request.getParameter("id");
		loginsession=request.getSession(true);
		loginsession.setAttribute("usersession", studentid);
		loginsession.setMaxInactiveInterval(-20);
		idcheck2=request.getParameter("id2");
		
		
		if(idcheck2.equals("signout"))
		{
			loginsession.setAttribute("usersession", "");
			loginsession.invalidate();
	
			response.sendRedirect("middle.jsp");
			
		}
	
		studentcollegedetails scd=new studentcollegedetails();
		studentcollegedatamodel scdm=new studentcollegedatamodel();
		studentpgcollegedetails spcd=new studentpgcollegedetails();
		studentpgcollegedatamodel spcdm=new studentpgcollegedatamodel();
		studentregistration sr=new studentregistration();
		studentdatamodel sdm=new studentdatamodel();
		String str1;
		if(idcheck2.equals("fstudentlogin"))
		{
			
			
			ArrayList list1=spcdm.getAllpgcolleges(studentid);
			int size1=list1.size();
			for(int i=0;i<size1;i++)
			{
			spcd=(studentpgcollegedetails)list1.get(i);
			}
			str1=spcd.getPgcourse();
			try
			{
			if(str1.equals(null))
			{}
			
else
{
				
response.sendRedirect("mainprofile.jsp?id="+studentid+"&id2="+spcd.getPgcourse()+"&id3="+spcd.getPgcollegename()+"&id4="+spcd.getPgtrade()+"&id5="+spcd.getPgpercentage()+"&id6="+spcd.getPgbacklogs()+"&id7="+spcd.getPgyearofpassing());
				
}
}
	catch(Exception e)
	{
		ArrayList list=scdm.getAllcolleges(studentid);
		int size=list.size();
		for(int i=0;i<size;i++)
		{
		scd=(studentcollegedetails)list.get(i);
		}
		response.sendRedirect("mainprofile.jsp?id="+studentid+"&id2="+scd.getGcourse()+"&id3="+scd.getGcollegename()+"&id4="+scd.getGtrade()+"&id5="+scd.getGpercentage()+"&id6="+scd.getGbacklogs()+"&id7="+scd.getGyearofpassing());
		System.out.println("mai de rha hu exception hello");
	}
			
			
			
		}
		
		
if(idcheck2.equals("login"))
{
	System.out.print("yha aagya mai");
	int g=0;
	double pwd=0;
	String password=request.getParameter("password");
	String emailid=request.getParameter("emailid");
	String pwdcehck1=sdm.getstudentdetails(emailid);


	System.out.print(pwdcehck1);
	
	
	
	
	
	
	
		int a=password.length();
		for(int i=0;i<a;i++)
		{
			
			int f=(int)(password.charAt(i));
			g=g+f;
		}


			
		double b=Math.tan(a);
		
		double c=Math.sin(a);
		
		double d=Math.cos(a);
		

		pwd=pwd+b+c+d+g;
	String pwdcheck=Double.toString(pwd);
	System.out.println(pwdcheck);
	if(pwdcheck.equals(pwdcehck1))
	{
		ArrayList list1=spcdm.getAllpgcolleges(studentid);
		int size1=list1.size();
		for(int i=0;i<size1;i++)
		{
		spcd=(studentpgcollegedetails)list1.get(i);
		}
		str1=spcd.getPgcourse();
		try
		{
		if(str1.equals(null))
		{}
		
else
{
			
response.sendRedirect("mainprofile.jsp?id="+studentid+"&id2="+spcd.getPgcourse()+"&id3="+spcd.getPgcollegename()+"&id4="+spcd.getPgtrade()+"&id5="+spcd.getPgpercentage()+"&id6="+spcd.getPgbacklogs()+"&id7="+spcd.getPgyearofpassing());
			
}
}
catch(Exception e)
{
	ArrayList list=scdm.getAllcolleges(studentid);
	int size=list.size();
	for(int i=0;i<size;i++)
	{
	scd=(studentcollegedetails)list.get(i);
	}
	response.sendRedirect("mainprofile.jsp?id="+studentid+"&id2="+scd.getGcourse()+"&id3="+scd.getGcollegename()+"&id4="+scd.getGtrade()+"&id5="+scd.getGpercentage()+"&id6="+scd.getGbacklogs()+"&id7="+scd.getGyearofpassing());
	System.out.println("mai de rha hu exception hello");
}

		
	}
	else 
	{
		response.sendRedirect("middle.jsp?id=error");
	}

		
}		
		
	}




}