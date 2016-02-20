
<%if(session.getAttribute("usersession")==null)
{	
	response.sendRedirect("register.jsp");
}%>




<jsp:include page="head.jsp"></jsp:include>
<%@page import="studentmodel.*"%>
<%@page import="projectbean.*"%>
<%@page import="java.util.*"%>
<script type="text/javascript">	
		
		$(document).ready(function()
		{	 var bool1=true,bool2=true;
			
			$("#one").hide();
			$("#valid").hide();
			//$("p").fadeIn("slow");
			$("#show").click(function(){
				$("#one").show();
				$("#valid").show();
				$("#diploma").fadeIn("slow");
				$("#12th").fadeOut("slow");
				$("#validations").show();
				$("#validations1").hide();
				$("#hidediploma").hide();
				$("#validations").click(function()
				{
				if ($("#int1").val()==""|| $("#int2").val()==""||$("#selectcourse").val()==0 || $("#selectcollege").val()==0|| $("#diplomaper").val()==""|| $("#yearofpassing").val()=="") 
				{
				alert('All Fileds Are Mandatory');
				return false;
				}
				if($("#yearofpassing").val().length!=4)
					{
						alert('Enter The Correct Year of Passing!');
						return false;
					}
				});	
			});
			$("#hide").click(function(){
				$("#one").show();
				$("#valid").show();
				$("#12th").fadeIn("slow");
				$("#diploma").fadeOut("slow");
				$("#validations1").show();
				$("#validations").hide();
				$("#hidediploma").hide();
				$("#validations1").click(function()
						{
						if ($("#int1").val()==""|| $("#int2").val()==""||$("#int3").val()==""|| $("#int4").val()=="") {
						
						alert('All Fileds Are Mandatory');
						return false;
						}
						});
			});
			
		});
		</script>

<script type="text/javascript">

function checkNumeric()
{
	
	temp1="";temp2="";temp3="";temp4="";temp5="";temp6="";

	tid1=document.getElementById("int1");
	tid2=document.getElementById("int2");
	tid3=document.getElementById("int3");
	tid4=document.getElementById("int4");
	tid5=document.getElementById("diplomaper");
	tid6=document.getElementById("yearofpassing");

	
	
	a=tid1.value;
	al=a.length;
	b=tid2.value;
	bl=b.length;
	c=tid3.value;
	cl=c.length;
	d=tid4.value;
	dl=d.length;
	e=tid5.value;
	el=e.length;
	f=tid6.value;
	fl=f.length;
	
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
	for(i=0;i<cl;i++)
	{
		if(c[i]>='0' && c[i]<='9')
		{
			temp3=temp3+c[i];
		}
	}
	for(i=0;i<dl;i++)
	{
		if(d[i]>='0' && d[i]<='9')
		{
			temp4=temp4+d[i];
		}
	}
	for(i=0;i<el;i++)
	{
		if(e[i]>='0' && e[i]<='9')
		{
			temp5=temp5+e[i];
		}
	}
	for(i=0;i<fl;i++)
	{
		if(f[i]>='0' && f[i]<='9')
		{
			temp6=temp6+f[i];
		}
	}
	tid1.value=temp1;
	tid2.value=temp2;
	tid3.value=temp3;
	tid4.value=temp4;
	tid5.value=temp5;
	tid6.value=temp6;
}
	
</script>

<div class="featured-content">
			<div class="substrate">
				<img src="images/site_bg.jpg" class="fullwidth" alt="">			</div>
						<div class="row">
							<div class="page-title">
					<h1 class="nomargin">Profile/Update Your Curiculum Details</h1>
				</div>
				<!-- /page title -->				
						</div>
				
		</div>
		<!-- /featured -->
		<%

        if(request.getParameter("id")!=null)
        {
        	if(request.getParameter("id").equals("error"))
        	{%>
        	<div class="error">
        	Please Try Again and fill All filed Correctly !
        	</div>
        	<%
        	}}
        	 %>
		
		<div class="main-content">
			<div class="row"><div class="sevencol column">
	<div class="user-profile">
	
	<div class="user-image">			
	<div class="bordered-image thick-border">
<img src="images/<%=session.getAttribute("usernames")%>.jpg" class="avatar" alt="" width="200">	
</div>
	
</div>

<div class="user-description">
	<form action="studentcontroller?id=addprofilepart1" class="formatted-form" method="POST">
		
		
	<div  class="sixcol column">
			<div class="field-wrapper">
			<label>Xth RollNo*</label>
<input onkeyup="checkNumeric();" name="rollno1" placeholder="xth RollNo" type="text" id="int1">
			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
			<div class="clear"></div>
<label>Xth% *</label>	
<input onkeyup="checkNumeric();" name="xper" placeholder="xth Percentage" type="text" id="int2">
			</div>
		</div>				
		<div class="clear"></div>
			<div class="clear"></div>
			<div id="hidediploma" >
		<label>Whether Done Diploma</label>&nbsp;&nbsp;&nbsp;&nbsp;
			
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="clear"></div>		
<div class="sixcol column">			
<a href="#" id="show" >Yes</a>
</div>
<div class="sixcol column last">
<a href="#" id="hide" >No</a>
</div>
</div>
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="clear"></div>
<div id="one">			
		<div id="12th">	
			<div class="sixcol column">
			<div class="field-wrapper">
			<label>XIIth RollNo*</label>
<input onkeyup="checkNumeric();" name="rollno2" placeholder="12th RollNo" type="text" id="int3">
			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
			<div class="clear"></div>
<label>XIIth *</label>	
<input onkeyup="checkNumeric();" name="xiiper" placeholder="12th Percentage" type="text" id="int4">
			</div>
		</div>
		</div>				
		<div class="clear"></div>
					
		
		
		<div id="diploma">
		<div class="sixcol column">
			<div class="field-wrapper">
<label>Trade</label>
		<select   name="selecttrade" id="selectcourse"  >
        <option value="0">Select Trade &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
    	   <%
    	   
    	   
    	   tradedatamodel data1=new tradedatamodel();
       	ArrayList list1=data1.getAllgtrades();
       	int size1=list1.size();
       	
       	for(int i=0;i<size1;i++)
       	{
       	gtrades trade=(gtrades)list1.get(i);
    	
    	 %>
    	 <option value="<%=trade.getGtradeid() %>"><%=trade.getGtradename() %></option>
    	<%}
    	 %>
          </select>
		
		
			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
			<label>Institute</label>
			<select   name="selectcollege" id="selectcollege">
        <option value="0">Select college</option>
    	   <%
    	   
    	   
    	   diplomadatamodel data=new diplomadatamodel();
       	ArrayList list=data.getAlldiplomacolleges();
       	int size=list.size();
       	
       	for(int i=0;i<size;i++)
       	{
       	diplomacolleges college=(diplomacolleges)list.get(i);
    	
    	 %>
    	 <option value="<%=college.getDcollegeid() %>"><%=college.getDcollegename() %></option>
    	<%}
    	 %>
          </select>

			</div>
		</div>				
		<div class="clear"></div>
		<div class="sixcol column">
			<div class="field-wrapper">
		<label>Percentage</label>
<input onkeyup="checkNumeric();" name="diplomaper" placeholder="Enter Percentage" type="text" id="diplomaper">	
			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
		<label>Year Of Passing</label><input onkeyup="checkNumeric();"name="yop" id="yearofpassing" placeholder="Year of Passing" type="text">
			</div>
		</div>
		
		
		</div>
		
</div>		
		
		<div class="clear"></div>
		<div id=valid>
<button type=submit class="button submit-button left" id="validations">Submit</button>  
<button type=submit class="button submit-button left" id="validations1">Submit</button>
</div>		
	</form>
</div>			</div>
</div>
</body></html>