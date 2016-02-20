<html lang="en-US" class="wf-opensans-n4-active wf-opensans-i4-active 

wf-opensans-n6-active wf-active"><head>
<meta http-equiv="Content-Type" 

content="text/html; charset=UTF-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Get Placed</title>
	
	


<link rel="stylesheet" id="general-css" href="css/style.css" type="text/css" 

media="all">


<script src="javascript/webfont.js" type="text/javascript" async=""></script>

<script type="text/javascript" src="javascript/jquery.js"></script>

<script type="text/javascript" src="javascript/jquery.hoverIntent.min.js"></script>

<script type="text/javascript" src="javascript/jquery.themexSlider.js"></script>

<script type="text/javascript" src="javascript/general.js"></script>
<script type="text/javascript">


function hasFormValidation() {

    return (typeof document.createElement( 'input' ).checkValidity == 'function');

};
if( hasFormValidation() ) 
{
}
else
{
	window.open("error.jsp","_self");
		
}
</script>

<script type="text/javascript" src="javascript/jquery-1.11.2.js"></script>
		<script type="text/javascript">	
		
		$(document).ready(function()
		{	
			
			$("#lone").hide();
			$("#ltwo").hide();
			$("#lplay1").hide();
			//$("p").fadeIn("slow");
			$("#lplay").click(function(){
				$("#lplay").hide();
				$("#lplay1").show("slow");
				$("#lone").slideDown(2000);
				$("#ltwo").slideDown(2000);
			});
			$("#lplay1").click(function(){
				$("#lone").hide();
				$("#ltwo").hide();
				$("#lplay1").hide();
				$("#lplay").show();
			});
		});
		</script>
<style type="text/css">
@font-face {
font-family: "Crete Round";

font-weight: normal;
font-style: normal;
}

#lone{


 position: absolute;
    top: 50%;
    left: 50%;
    width: 500px;
    height: 300px;
    margin-top: 150px;
    margin-left: -200px;

}

</style>

		
		
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,400italic,600" 
media="all">
</head>

<body class="home page page-id-2 page-template-default">

	<div class="site-wrap">
	
		<div class="header-wrap">
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
		
		
			<header class="site-header">
				<div class="row">
					<div class="site-logo left">
<a href="index.jsp" rel="home">
<img src="images/1.png" style="border:double 10px #4465763;border-radius:50px" alt="piet">
						</a>
					</div>


<!-- /logo -->
<div class="header-options right clearfix">					

<div class="login-options right">
								

<div class="button-wrap left tooltip login-button">
<a href="" id="lplay" class="button dark">Sign In</a>
<a href="" id="lplay1" class="button dark">Sign In</a>
</div>

								

<div class="button-wrap left">
								

<a href="register.jsp" class="button">
								

Register</a>
</div>
</div>
<!-- /login options -->							

			

<nav class="header-navigation right">
<div class="menu">
<ul id="menu-main-menu" class="menu">
<li id="menu-item-187" class="menu-item menu-item-type-post_type 

menu-item-object-page current-menu-item page_item page-item-2 current_page_item 

current-menu-ancestor current-menu-parent current_page_parent 

current_page_ancestor menu-item-has-children menu-item-187">
<a href="index.jsp">Home</a>


<li id="menu-item-238" class="menu-item menu-item-type-taxonomy 

menu-item-object-course_category menu-item-238">



<li id="menu-item-603" class="menu-item menu-item-type-post_type 

menu-item-object-page menu-item-603">
<a href="support.jsp">Support</a></li>
</ul>
</div>						
</div>
</div>		
</div>


<!-- Header Finished-->