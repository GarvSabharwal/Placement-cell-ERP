

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projectbean.*;
import studentmodel.*;

/**
 * Servlet implementation class collegecontroller
 */
@WebServlet("/admincontroller")
public class admincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		collegedatamodel cdm=new collegedatamodel();
		pgcollegedatamodel pgcdm=new pgcollegedatamodel();
		pgcoursedatamodel pgcodm=new pgcoursedatamodel();
		tradedatamodel tdm=new tradedatamodel();
		coursedatamodel codm=new coursedatamodel();
		diplomadatamodel ddm=new diplomadatamodel();
		yopdatamodel yopdm=new yopdatamodel();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
				
		String strCheck=request.getParameter("id");
		
//////////////////////////college insertion starts//////////////////////////////				
		if(strCheck.equals("entercollege"))
		{	
		String Cn=request.getParameter("collegename");
		//String cid[]=request.getParameterValues("cid");
		//for(int i=0;i<cid.length;i++)
		//System.out.print("djjhfdshfsdhj"+cid[i]);
	
		gcolleges gc=new gcolleges();
		gc.setCollegename(Cn);
		int i=cdm.insertcollege(gc);
		if(i>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("college.jsp?id=collegesubmitted");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("college.jsp?id=collegenotsubmitted");
			rd.forward(request, response);
		}
			
		}
////////////////////////////college insertion ends///////////////////////////

//////////////////////////pgcollege insertion starts//////////////////////////////				
if(strCheck.equals("enterpgcollege"))
{	
String Cn1=request.getParameter("pgcollegename");
//String cid[]=request.getParameterValues("cid");
//for(int i=0;i<cid.length;i++)
System.out.print(request.getParameter("pgcollegename"));

pgcolleges pgc=new pgcolleges();
pgc.setPgcollegename(Cn1);
int i=pgcdm.insertpgcollege(pgc);
if(i>0)
{
RequestDispatcher rd=request.getRequestDispatcher("pgcolleges.jsp?id=pgcollegesubmitted");
rd.forward(request, response);
}
else
{
RequestDispatcher rd=request.getRequestDispatcher("pgcolleges.jsp?id=pgcollegenotsubmitted");
rd.forward(request, response);
}

}
////////////////////////////pgcollege insertion ends///////////////////////////

		
		
///////////////////////////diploma college starts///////////////////////////		
		else if(strCheck.equals("enterdcollege"))
		{
			
			String Cn=request.getParameter("dcollegename");
			//String cid[]=request.getParameterValues("cid");
			//for(int i=0;i<cid.length;i++)
			//System.out.print("djjhfdshfsdhj"+cid[i]);
		
			diplomacolleges dc=new diplomacolleges();
			dc.setDcollegename(Cn);
			int i=ddm.insertdiplomacollege(dc);
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("diplomacollege.jsp?id=dcollegesubmitted");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("diplomacollegecollege.jsp?id=dcollegenotsubmitted");
				rd.forward(request, response);
			}
		}
////////////////////////////////diplomacollegeends//////////////////////////
		
///////////////////////////trade insertion starts////////////////////////////		
		else if(strCheck.equals("entertrade"))
		{	
		String Cn=request.getParameter("trade");
				
	
		gtrades gt=new gtrades();
		gt.setGtradename(Cn);
		int i=tdm.inserttrade(gt);
		if(i>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("trades.jsp?id=tradesubmitted");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("trades.jsp?id=tradenotsubmitted");
			rd.forward(request, response);
		}
		
		}
////////////////////////trade insertion Ends//////////////////////////////	
		
//////////////////////////////////course insertion///////////////////////		
		else if(strCheck.equals("entercourse"))
		{	
		String Cn=request.getParameter("course");
				
	
		course c=new course();
		c.setCoursename(Cn);
		int i=codm.insertcourse(c);
		if(i>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("courses.jsp?id=coursesubmitted");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("courses.jsp?id=coursenotsubmitted");
			rd.forward(request, response);
		}
		}
		
///////////////////////////////////////course insertion ends//////////////////
		
//////////////////////////////////pgcourse insertion///////////////////////		
else if(strCheck.equals("enterpgcourse"))
{	
String Cn2=request.getParameter("pgcourse");


pgcourse pgc=new pgcourse();
pgc.setPgcoursename(Cn2);
int i=pgcodm.insertpgcourse(pgc);
if(i>0)
{
RequestDispatcher rd=request.getRequestDispatcher("pgcourse.jsp?id=pgcoursesubmitted");
rd.forward(request, response);
}
else
{
RequestDispatcher rd=request.getRequestDispatcher("pgcourse.jsp?id=pgcoursenotsubmitted");
rd.forward(request, response);
}
}

///////////////////////////////////////course insertion ends//////////////////



		
		
//////////////////////////////////////Year of Passing starts/////////////////		
		
		else if(strCheck.equals("yop"))
		{	
		String Cn=request.getParameter("yop");
				
	
		yop c=new yop();
		c.setYop(Cn);
		int i=yopdm.insertyop(c);
		if(i>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("yearofpassing.jsp?id=yopsubmitted");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("yearofpassing.jsp?id=yopnotsubmitted");
			rd.forward(request, response);
		}
		}
		
////////////////////////////////////yop updation ends/////////////////////////


		
////////////////////////// trade deletion Starts//////////////////////////////		
		String strCheck1=request.getParameter("id");
		String strCheck2=request.getParameter("id1");
		System.out.println(request.getParameter("id1"));
		if(strCheck1.equals("deletetrade"))
		{
			
			int i=tdm.deletetrade(strCheck2);
			System.out.print(i);
			if(i>0)
			{
				response.sendRedirect("trades.jsp?id=deleted");
			}
			else
			{
				response.sendRedirect("trades.jsp?id=notdeleted");
			}

	}
//////////////////////////trade deletion ends////////////////////////////////
//////////////////////////yop deletion Starts//////////////////////////////		
else if(strCheck1.equals("deleteyop"))
{
int i=yopdm.deleteyop(strCheck2);
if(i>0)
{
response.sendRedirect("yearofpassing.jsp?id=deleted");
//RequestDispatcher rd=request.getRequestDispatcher("college.jsp");
//rd.forward(request, response);
}

}
		
		
//////////////////////////college deletion Starts//////////////////////////////		
		else if(strCheck1.equals("deletecollege"))
		{
			int i=cdm.deletecollege(strCheck2);
			if(i>0)
			{
				response.sendRedirect("college.jsp?id=deleted");
				//RequestDispatcher rd=request.getRequestDispatcher("college.jsp");
				//rd.forward(request, response);
			}
		
		}
//////////////////////////college deletion ends//////////////////////////////
		
//////////////////////////pgcollege deletion Starts//////////////////////////////		
else if(strCheck1.equals("deletepgcollege"))
{
int i=pgcdm.deletepgcollege(strCheck2);
if(i>0)
{
response.sendRedirect("pgcolleges.jsp?id=deleted");
//RequestDispatcher rd=request.getRequestDispatcher("college.jsp");
//rd.forward(request, response);
}

}
//////////////////////////pgcollege deletion ends//////////////////////////////
		
//////////////////////////diplomacollege deletion Starts//////////////////////////////		
else if(strCheck1.equals("deletediplomacollege"))
{
int i=ddm.deletediplomacollege(strCheck2);
if(i>0)
{
response.sendRedirect("diplomacollege.jsp?id=deleted");
//RequestDispatcher rd=request.getRequestDispatcher("college.jsp");
//rd.forward(request, response);
}

}
//////////////////////////pgcollege deletion ends//////////////////////////////		

/////////////////////////delete course starts//////////////////////////////////		
		else if(strCheck1.equals("deletecourse"))
		{
			int i=codm.deletecourse(strCheck2);
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("course.jsp?id=deleted");
				rd.forward(request, response);
			}
		}
/////////////////////////delete course Ends//////////////////////////////////////////
/////////////////////////delete pgcourse starts//////////////////////////////////		
else if(strCheck1.equals("deletepgcourse"))
{
int i=pgcodm.deletepgcourse(strCheck2);
if(i>0)
{
RequestDispatcher rd=request.getRequestDispatcher("pgcourse.jsp?id=deleted");
rd.forward(request, response);
}
}
/////////////////////////delete course Ends//////////////////////////////////////
////////////////////////////////////////////////deletion ends////////////////////////		
		
		
		}
	}

