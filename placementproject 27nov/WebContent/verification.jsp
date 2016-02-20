<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <jsp:include page="head.jsp"></jsp:include>
   <script type="text/javascript">
    
    document.getElementById(verify).value='';
    $("#verify").reset();
    
    </script> 
    
    
    
    
    <div class="featured-content">
			<div class="substrate">
				<img src="images/site_bg.jpg" class="fullwidth" alt="">			</div>
						<div class="row">
							<div class="page-title">
					<h1 class="nomargin">Verification </h1>
				</div>
				<!-- /page title -->				
						</div>
				
		</div>
		<!-- /featured -->


		<div class="main-content">
			<div class="row"><div class="eightcol column">
	<h1>Enter Verification ID & Verification Code </h1>
    
    
    
    
    
    <div class="fourcol column last">
		
		<form id="verify"class="formatted-form" action="profile.jsp" method="POST">
		<div class="message"></div>
		<div class="field-wrapper">
<label>	Verification Id:</label><span><input type="text" name="username" ></span>
		</div>
		<div class="field-wrapper">
<label>	Verification Code:</label><input type="password" name="verificationcode" >
		</div>			
		<button type=submit class="button 
submit-button left">Verify</button> 
				<div class="form-loader"></div>
		<input type="hidden" name="user_action" value="login_user">
		<input type="hidden" name="user_redirect" value="">
		<input type="hidden" name="nonce" class="nonce" value="f8cd077f7a">
		<input type="hidden" name="action" class="action" value="themex_update_user">
	</form>	
			
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>


								</div>
			</div>
    	</div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <jsp:include page="footer.jsp"></jsp:include>