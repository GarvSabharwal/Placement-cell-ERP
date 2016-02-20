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

class="nomargin">Enter Trades  </h1>
				</div>
				<!-- /page title -->			

	
						</div>
				
		</div>
		<!-- /featured -->
<%

        if(request.getParameter("id")!=null)
        {
        	if(request.getParameter("id").equals("notdeleted"))
        	{%>
        	<div class="error">
        		Email-Id Already Exist! Please Register with different Email-Id
        	</div>
        	<%
        	}
        	
        	else if(request.getParameter("id").equals("deleted"))
        	{ %>
        	<div class="success">
        		Please Verify Your Email By Clicking on the verification link send to you!
        	</div>
        	<%}
        	else if(request.getParameter("id").equals("captchaerror"))
        	{%>
        	<div class="error">
        		Invalid Captcha! Please Enter a valid Captcha
        	</div>
        	        	 <% }
        }

  
         %>

		<div class="main-content">
			<div class="row"><div class="eightcol column">
	<h1>Enter Trade</h1>
	
	
	
<form class="formatted-form" method="post" action=admincontroller?id=entertrade>
		
		<div class="sixcol column">
			<div class="field-wrapper">
<input type="text" name="trade"  placeholder="College Name" required autofocus>
			</div>					

			
				<div class="clear"></div>
		<button type=submit class="button 
submit-button left">Enter Trade</button>  		
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
    	<th>Trade ID</th>
    	<th>Trade Name</th>
    	</tr>
    	<%
    	tradedatamodel data=new tradedatamodel();
    	ArrayList list=data.getAllgtrades();
    	int size=list.size();
    	
    	for(int i=0;i<size;i++)
    	{
    	gtrades trade=(gtrades)list.get(i);
    	
    	
    	 %>
    	<tr>
    	<td><a href="#">Edit</a> | <a href="admincontroller?id=deletetrade&id1=<%=trade.getGtradeid() %>">Delete</td>
    	<td><%=trade.getGtradeid() %> </td>
    	<td><%=trade.getGtradename() %> </td>
    	</tr>
    	<%}
    	 %>
    </table>


			</div>
			<!-- /content -->
<jsp:include page="footer.jsp"></jsp:include>