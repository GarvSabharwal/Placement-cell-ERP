<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="head.jsp"></jsp:include>
    <script type="text/javascript" src="jquery-1.11.2.js"></script>
<script type="text/javascript">
	
$(document).ready(function()
		{	
			a=$("#rpassword").val();
			b=$("#rconfirmpassword").val();
			if(a!=b)
				{
					alert("password filed doest not match !" );
					return false;
				}
			
		});

</script>


    
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
	<h1>Register</h1>
	
	
	
<form class="formatted-form" method="post" action="studentcontroller?id=register">
		
		<div class="sixcol column">
			<div class="field-wrapper">
<label>User Name<label style="color:red">*</label></label>	<span>			
<input type="text" id="uname" name="username"  placeholder="Username" required autofocus></span>
			</div>					

			
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
			<label>Email Id<label style="color:red">*</label></label>	<span>
<input type="email" id="validemail" name="emailid"  placeholder="Email"  required autofocus></span>
			</div>
		</div>
		<div class="clear"></div>
		<div class="sixcol column">
			<div class="field-wrapper">
<label>Password <label style="color:red">*</label></label>	<span>			
<input type="password" id="rpassword" name="password"  placeholder="Password" required autofocus></span>
			</div>
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
<label>Confirm Password<label style="color:red">*</label></label>	<span>			
<input type="password" id="rconfirmpassword" name="confirmpassword"  placeholder="Repeat Password" required autofocus></span>
			</div>
		</div>
		<div class="sixcol column">
			<div class="field-wrapper">
<label>Captcha<label style="color:red">*</label></label>	<span>			
<input type="text" id="code" name="code" required autofocus></span>
			</div>
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
<img src="captcha"style="border:double 30px #4465763;border-radius:10px" alt="piet"> 
			</div>
		</div>
		<div class="clear"></div>
		
<button type=submit id="rvalidate" class="button submit-button left" onclick="demoValidationsr();">Register</button>  		

</form>
	
</div>

<div class="clear"></div>
								

</div>
			</div>
			<!-- /content -->
<jsp:include page="footer.jsp"></jsp:include>