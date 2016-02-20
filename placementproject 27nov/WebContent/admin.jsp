
<jsp:include page="adminhead.jsp"></jsp:include>


						


<div >


		<img src="images/background.jpg" class="fullwidth" alt="">



		<div id="lone" style="background-color:#495965;color:white;border:double 2px #18A7B5;">
		
		<div style="margin:20px;">
		
		<form class="formatted-form" method="post" action="logincontroller?id2=login">
		
			<h1>Student Login</h1>
			<% 
			if(request.getParameter("id")!=null)
        {
        	if(request.getParameter("id").equals("error"))
        	{%>
        	<div class="error">
        	Incorrect Password or ID !
        	</div>
        	<%
        	}}
        	 %>
			
		<div class="sixcol column ">
			<div class="field-wrapper">
			<label>Email Id<label style="color:red">*</label></label>	<span>
<input type="email" id="validemail" name="emailid"  placeholder="Email"  required autofocus></span>
			</div>
		</div>
		<div class="clear"></div>
		<div class="sixcol column">
			<div class="field-wrapper">
<label>Password <label style="color:red">*</label></label>	<span>			
<input type="password"  name="password"  placeholder="Password" required autofocus></span>
			</div>
		</div>
	<div class="clear"></div>
	<a href="">Forgot Password</a>
	<div class="clear"></div>	
<button type=submit  class="button submit-button left">Login</button>  		

</form>

		</div>
		<div style="margin:-235px 0px 0px 250px;" >
		
		<img src="images/pietlogo.png">
		</div>
		</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>