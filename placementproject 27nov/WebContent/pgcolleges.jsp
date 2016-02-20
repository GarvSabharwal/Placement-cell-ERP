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
        	if(request.getParameter("id").equals("pgcollegenotsubmitted"))
        	{%>
        	<div class="error">
        		Submission Error ! Please Try Again
        	</div>
        	<%
        	}
        	
        	else if(request.getParameter("id").equals("pgcollegesubmitted"))
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
	<h1>Enter PG College </h1>
	
	
	
<form class="formatted-form" method="post" action=admincontroller?id=enterpgcollege>
		
		<div class="sixcol column">
			<div class="field-wrapper">
<input type="text" name="pgcollegename"  placeholder="College Name" required autofocus>
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
    	<th>PG College ID</th>
    	<th>PG College Name</th>
    	</tr>
    	<%
    	pgcollegedatamodel data=new pgcollegedatamodel();
    	ArrayList list=data.getAllpgcolleges();
    	int size=list.size();
    	
    	for(int i=0;i<size;i++)
    	{
    	pgcolleges college=(pgcolleges)list.get(i);
    	
    	
    	 %>
    	<tr>
    	<td><a href="#">Edit</a> | <a href="admincontroller?id=deletepgcollege&id1=<%=college.getPgcollegeid()%>">Delete</td>
    	<td><%=college.getPgcollegeid()%> </td>
    	<td><%=college.getPgcollegename() %> </td>
    	</tr>
    	<%}
    	 %>
    </table>


			</div>
			<!-- /content -->
<jsp:include page="footer.jsp"></jsp:include>