<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="studentmodel.*"%>
<%@page import="projectbean.*"%>
<%@page import="java.util.*"%>
    <jsp:include page="adminhead.jsp"></jsp:include>
<div class="featured-content">
			<div class="substrate">
				<img src="images/site_bg.jpg" 

class="fullwidth" alt="">			</div>
						<div class="row">
							<div 

class="page-title">
					<h1 

class="nomargin">Enter Post Graduation Courses  </h1>
				</div>
				<!-- /page title -->			

	
						</div>
				
		</div>
		<!-- /featured -->
<%

        if(request.getParameter("id")!=null)
        {
        	if(request.getParameter("id").equals("pgcoursenotsubmitted"))
        	{%>
        	<div class="error">
        		Email-Id Already Exist! Please Register with different Email-Id
        	</div>
        	<%
        	}
        	
        	else if(request.getParameter("id").equals("pgcoursesubmitted"))
        	{ %>
        	<div class="success">
        		Course Submitted Successfully!
        	</div>
        	<%}
        	else if(request.getParameter("id").equals("deleted"))
        	{%>
        	<div class="success">
        		Course Deleted Successfully!
        	</div>
        	        	 <%} 
        }

  
         %>

		<div class="main-content">
			<div class="row"><div class="eightcol column">
	<h1>Enter Post Graduation Course</h1>
	
	
	
<form class="formatted-form" method="post" action=admincontroller?id=enterpgcourse>
		
		<div class="sixcol column">
			<div class="field-wrapper">
<input type="text" name="pgcourse"  placeholder="Course Name" required autofocus>
			</div>					

			
				<div class="clear"></div>
		<button type=submit class="button 
submit-button left">Enter course</button>  		
<div class="clear"></div>
</form>	
<div class="clear"></div>
</div>
			</div>
			</div>	

<div class="clear"></div>
</br>
<table>
    	<tr>
    	<th>Format</th>
    	<th>Course ID</th>
    	<th>Course Name</th>
    	</tr>
    	<%
    	pgcoursedatamodel data=new pgcoursedatamodel();
    	ArrayList list=data.getpgAllcourses();
    	int size=list.size();
    	
    	for(int i=0;i<size;i++)
    	{
    	pgcourse pgcourse=(pgcourse)list.get(i);
    	
    	
    	 %>
    	<tr>
    	<td><a href="admincontroller?id=editpgcourse&id1=<%=pgcourse.getPgcourseid() %>">Edit</a> | <a href="admincontroller?id=deletepgcourse&id1=<%=pgcourse.getPgcourseid() %>">Delete</td>
    	<td><%=pgcourse.getPgcourseid() %> </td>
    	<td><%=pgcourse.getPgcoursename() %> </td>
    	</tr>
    	<%}
    	 %>
    </table>


			</div>
			<!-- /content -->
<jsp:include page="footer.jsp"></jsp:include>