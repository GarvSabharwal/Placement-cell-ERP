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
	<h1>Enter Diploma College </h1>
	
	
	
<form class="formatted-form" method="post" action=admincontroller?id=enterdcollege>
		
		<div class="sixcol column">
			<div class="field-wrapper">
<input type="text" name="dcollegename"  placeholder="College Name" required autofocus>
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
    	<th>Diploma College ID</th>
    	<th>Diploma College Name</th>
    	</tr>
    	<%
    	diplomadatamodel data=new diplomadatamodel();
    	ArrayList list=data.getAlldiplomacolleges();
    	int size=list.size();
    	
    	for(int i=0;i<size;i++)
    	{
    	diplomacolleges college=(diplomacolleges)list.get(i);
    	
    	
    	 %>
    	<tr>
    	<td><a href="#">Edit</a> | <a href="admincontroller?id=deletediplomacollege&id1=<%=college.getDcollegeid()%>">Delete</td>
    	<td><%=college.getDcollegeid()%> </td>
    	<td><%=college.getDcollegename() %> </td>
    	</tr>
    	<%}
    	 %>
    </table>


			</div>
			<!-- /content -->
<jsp:include page="footer.jsp"></jsp:include>