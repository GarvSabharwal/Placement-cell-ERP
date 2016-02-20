<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="head.jsp"></jsp:include>
   

    
       <div class="featured-content">
			<div class="substrate">
				<img src="images/site_bg.jpg" 

class="fullwidth" alt="">			</div>
						<div class="row">
							<div 

class="page-title">
					<h1 

class="nomargin">Update Profile </h1>
				</div>
				<!-- /page title -->			

	
						</div>
				
		</div>
		<!-- /featured -->
<%
	String str=request.getParameter("id");
        if(request.getParameter("id")!=null)
        {
        	if(request.getParameter("id").equals("registererror"))
        	{%>
        	<div class="error">
        		Email-Id Already Exist! Please Register with different Email-Id
        	</div>
        	<%
        	}
        	
        	else if(request.getParameter("id").equals("registersuccess"))
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
        	else if(request.getParameter("id").equals("usernameerror"))
        	{%>
        	<div class="error">
        		UserName Already Taken! Please Select another UserName 
        	</div>
        	<% }
        }

  
         %>

		<div class="main-content">
			<div class="row"><div class="eightcol column">
	<h1>Update Profile</h1>
	
	
	
<form class="formatted-form" method="post" action="studentcontroller?id=updateprofile">
		
		<div class="sixcol column">
			<div class="field-wrapper">
<label>Enter Your Backlogs	<span>			
<input type="text"  name="backlogs"  placeholder="Enter Backlogs" required autofocus></span>
			</div>					

			
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
			<label>Enter Your Percentage	<span>
<input type="text"  name="percentage"  placeholder="Percentage"  required autofocus></span>
			</div>
		</div>
		<div class="clear"></div>
				
<button type=submit class="button submit-button left" >Submit</button>  		

</form>
	
</div>

<div class="clear"></div>
								

</div>
			</div>
			<!-- /content -->
<jsp:include page="footer.jsp"></jsp:include>