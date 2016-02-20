
<!--  %if(session.getAttribute("usersession")==null)
{	
	response.sendRedirect("register.jsp");
}%--> 


<jsp:include page="head.jsp"></jsp:include>



<script type="text/javascript">

function checkNumeric()
{
	
	temp1="";
	temp2="";
	tid1=document.getElementById("int1");
	tid2=document.getElementById("int2");
	

	
	
	a=tid1.value;
	al=a.length;
	b=tid2.value;
	bl=b.length;
	
	
	for(i=0;i<al;i++)
	{
		if(a[i]>='0' && a[i]<='9')
		{
			temp1=temp1+a[i];
		}
	}
	for(i=0;i<bl;i++)
	{
		if(b[i]>='0' && b[i]<='9')
		{
			temp2=temp2+b[i];
		}
	}
	
	tid1.value=temp1;
	tid2.value=temp2;
	
}
	
</script>





<div class="featured-content">
			<div class="substrate">
				<img src="images/site_bg.jpg" class="fullwidth" alt="">			</div>
						<div class="row">
							<div class="page-title">
					<h1 class="nomargin">Profile/Update Your Details</h1>
				</div>
				<!-- /page title -->				
						</div>
				
		</div>
		<!-- /featured -->
		<%
	String str=request.getParameter("id");
        if(request.getParameter("id")!=null)
        {
        	if(request.getParameter("id").equals("error"))
        	{%>
        	<div class="error">
        		Please Try Again Or Report To Us!
        	</div>
        	<%
        	}
        	else if(request.getParameter("id").equals("success"))
        	{%>
        		<div class="success">
        		Image Uploaded Successfully Now Fill Your Details
        	</div>	
        	<%}
        	
        	
        }
%>

		
		<div class="main-content">
			<div class="row"><div class="sevencol column">
	<div class="user-profile">
				<div class="user-image">		
				
				
	<div class="bordered-image thick-border">
			
	
		<img src="images/null.jpg" class="avatar" alt="" width="200">
        	
        	
			</div>
	<div class="user-image-uploader">
		<form action="f" enctype="multipart/form-data" method="POST">
			<input type="file" name="file" />
                <input type="submit" value="upload" />
		
			
		</form>
	</div>
</div>
<div class="user-description">
	<form action="studentcontroller?id=addpersonaldetails" class="formatted-form" method="POST">
		
		
	<div class="sixcol column">
<div class="field-wrapper">
	<label>First Name<label style="color:red">*</label></label>	<span><input name="firstname" placeholder="First Name" type="text" autofocus required></span>
			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
			<label>Last Name<label style="color:red">*</label></label>
				<input name="lastname" placeholder="Last Name" type="text" autofocus required>
			</div>
		</div>				
		<div class="clear"></div>
		<div class="sixcol column">
			<div class="field-wrapper">
			<label>Date Of Birth<label style="color:red">*</label></label>	<input name="dob" placeholder="DD/MM/YY" type="Date" autofocus required>
			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
			<div class="clear"></div>
			<label for=Gender>Gender&nbsp;<b style="color:#FF0000"><label style="color:red">*</label></b></label><br/>
			<input  value=male name=gender type=radio>&nbsp;&nbsp;
			<label for=Male>Male</label>&nbsp;&nbsp;&nbsp;&nbsp;
			<input value=female name=gender type=radio >&nbsp;&nbsp;
			<label for=female>Female</label>
			
			</div>
		</div>				
		<div class="clear"></div>
				
		<label for=address>Address&nbsp;<b class="icon_required" style="color:#FF0000"><label style="color:red">*</label></b></label>
		<textarea id=address name="address" rows=4 required></textarea>		
		<div class="clear"></div>
		
		
		
		<div class="sixcol column">
			<div class="field-wrapper">
			<label>City<label style="color:red">*</label></label><input name="city" placeholder="Karnal" type="text" autofocus required>
			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
			<label>State<label style="color:red">*</label></label><input name="state" placeholder="Haryana" type="text" autofocus required>
			</div>
		</div>				
		<div class="clear"></div>
		<div class="sixcol column">
			<div class="field-wrapper">
			<label>PinCode<label style="color:red">*</label></label>	<input onkeyup="checkNumeric();" name="pincode" placeholder="1300001" type="text" id="int2" autofocus required>
			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
		<label>Mobile No<label style="color:red">*</label></label><input onkeyup="checkNumeric();" name="number" placeholder="9876543210" type="text" id="int1" autofocus required>
			</div>
		</div>
		<div class="clear"></div>
  <button type=submit class="button submit-button left">Submit</button>
		<input name="user_action" value="update_profile" type="hidden">
		<input name="nonce" value="5059c7c141" type="hidden">
   </form>
   
</div>			
</div>
</div>
</body>
</html>