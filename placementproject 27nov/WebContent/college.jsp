<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="studentmodel.collegedatamodel"%>
<%@page import="projectbean.gcolleges"%>
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

class="nomargin">Registration  </h1>
				</div>
				<!-- /page title -->			

	
						</div>
				
		</div>
		<!-- /featured -->
<%

        if(request.getParameter("id")!=null)
        {
        	if(request.getParameter("id").equals("collegenotsubmitted"))
        	{%>
        	<div class="error">
        		Submission Error ! Please Try Again
        	</div>
        	<%
        	}
        	
        	else if(request.getParameter("id").equals("collegesubmitted"))
        	{ %>
        	<div class="success">
        		College Submitted Successfully!
        	</div>
        	<%}
        	else if(request.getParameter("id").equals("deleted"))
        	{%>
        	<div class="success">
        		College Deleted Successfully!
        	</div>
        	        	 <%} 
        }

  
         %>

		<div class="main-content">
			<div class="row"><div class="eightcol column">
	<h1>Enter College </h1>
	
	
	
<form class="formatted-form" method="post" action=admincontroller?id=entercollege>
		
		<div class="sixcol column">
			<div class="field-wrapper">
<input type="text" name="collegename"  placeholder="College Name" required autofocus>
			</div>					

			
				<div class="clear"></div>
		<button type=submit class="button 
submit-button left">Enter College</button>  		
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
    	<th></th>
    	<th>College ID</th>
    	<th>College Name</th>
    	</tr>
    	<%
    	collegedatamodel data=new collegedatamodel();
    	ArrayList list=data.getAllgcolleges();
    	int size=list.size();
    	
    	for(int i=0;i<size;i++)
    	{
    	gcolleges college=(gcolleges)list.get(i);
    	
    	
    	 %>
    	<tr>
    	<td><a href="#">Edit</a> | <a href="admincontroller?id=deletecollege&id1=<%=college.getCollegeid() %>">Delete</td>
    	<td><%=college.getCollegeid()%> </td>
    	<td><%=college.getCollegename() %> </td>
    	</tr>
    	<%}
    	 %>
    </table>


			</div>
			<!-- /content -->
<jsp:include page="footer.jsp"></jsp:include>