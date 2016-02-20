
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
		{	
			
			$("#one").hide();
			$("#valid").hide();
			$("#yes").click(function(){
				$("#one").show();
				$("#valid").show();
				$("#pg").fadeIn("slow");
				$("#validations").show();
				$("#validations1").hide();
				$("#hidepg").hide();
				$("#validations").click(function()
				{
				if ($("#int1").val()==0|| $("#int2").val()==0||$("#int3").val()==0 || $("#int4").val()==0||$("#int5").val()==0|| $("#int6").val()==0||$("#int7").val()==0 || $("#int8").val()==0){
				alert('All fields are mandatory');
				
				return false;
				}
				});	
			});
			$("#no").click(function(){
				$("#one").show();
				$("#valid").show();
				$("#pg").fadeOut("slow");
				$("#validations1").show();
				$("#validations").hide();
				$("#hidepg").hide();
				$("#validations1").click(function()
						{
						if ($("#int1").val()==0|| $("#int2").val()==0||$("#int3").val()==0|| $("#int4").val()==0) {
						alert('All fields are mandatory');
						
						return false;
						}
						});
			});
			
		});
		</script>

<script type="text/javascript">

function checkNumeric()
{
	
	temp5="";temp6="";

	tid5=document.getElementById("pgyearofpassing");
	tid6=document.getElementById("yearofpassing");

	
	
	e=tid5.value;
	el=e.length;
	f=tid6.value;
	fl=f.length;
	
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
	<form action="studentcontroller?id=addprofilepart2" class="formatted-form" method="POST">
		
		
	<div class="sixcol column">
<div class="field-wrapper">
	<label>Select Course</label>	
			<select   name="selectcourse" id="int1" >
        <option value="0">Select course &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </option>
    	   <%
    	   
    	   
    	   coursedatamodel data1=new coursedatamodel();
       	ArrayList list1=data1.getAllcourses();
       	int size1=list1.size();
       	
       	for(int i=0;i<size1;i++)
       	{
       	course course=(course)list1.get(i);
    	
    	 %>
    	 <option value="<%=course.getCoursename() %>"><%=course.getCoursename() %></option>
    	<%}
    	 %>
          </select>
		
			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
			<label>Select College</label>	
<select   name="selectcollege" id="int2" >
        <option value="0">Select college</option>
    	   <%
    	   
    	   
    	   collegedatamodel data=new collegedatamodel();
       	ArrayList list=data.getAllgcolleges();
       	int size=list.size();
       	
       	for(int i=0;i<size;i++)
       	{
       	gcolleges gcollege=(gcolleges)list.get(i);
    	
    	 %>
    	 <option value="<%=gcollege.getCollegeid() %>"><%=gcollege.getCollegename() %></option>
    	<%}
    	 %>
          </select>
		
			</div>
		</div>				
		<div class="clear"></div>
		<div class="sixcol column">
			<div class="field-wrapper">
			<label>Select Trade</label>	
			<select   name="selecttrade" id="int3" >
        <option value="0">Select Trade  </option>
    	   <%
    	   
    	   
    	   tradedatamodel data2=new tradedatamodel();
       	ArrayList list2=data2.getAllgtrades();
       	int size2=list2.size();
       	
       	for(int i=0;i<size2;i++)
       	{
       	gtrades trade=(gtrades)list2.get(i);
    	
    	 %>
    	 <option value="<%=trade.getGtradename() %>"><%=trade.getGtradename() %></option>
    	<%}
    	 %>
          </select>
	
			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
		<label>Year Of Passing</label>
<input onkeyup="checkNumeric();"name="yop" id="yearofpassing" placeholder="Year of Passing" type="text">
			</div>
			</div>
						
		<div class="clear"></div>
		<div class="sixcol column">
			<div class="field-wrapper">
			</div>
		</div>			
	
		<div class="sixcol column last">
			<div class="field-wrapper">
			<div class="clear"></div>
			
			</div>
		</div>
		
		<div class="clear"></div>
			<div class="clear"></div>
		<div id="hidepg" >			
		<label>Whether Doing Post Graduation</label>&nbsp;&nbsp;&nbsp;&nbsp;
			
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="clear"></div>		
<div class="sixcol column">			
<a href="#" id="yes" >Yes</a>
</div>
<div class="sixcol column last">
<a href="#" id="no" >No</a>
</div>
</div>
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="clear"></div>
<div id="one">			
		<div id="pg">				
		<div class="sixcol column">
			<div class="field-wrapper">
			<label>Course</label>
<select name="selectpgcourse" id="int5">
        <option value="0">Select Course</option>
    	   <%
    	   
    	   
    	   pgcoursedatamodel pgcdata=new pgcoursedatamodel();
       	ArrayList pgclist=pgcdata.getpgAllcourses();
       	int pgcsize=pgclist.size();
       	
       	for(int i=0;i<pgcsize;i++)
       	{
       	pgcourse pgcourse=(pgcourse)pgclist.get(i);
    	
    	 %>
    	 <option value="<%=pgcourse.getPgcoursename() %>"><%=pgcourse.getPgcoursename() %></option>
    	<%}
    	 %>
          </select>

			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
			<label>Institute</label>	
<select name="selectpgcollege" id="int6">
        <option value="0">Select college</option>
    	   <%
    	   
    	   
    	   pgcollegedatamodel pgdata=new pgcollegedatamodel();
       	ArrayList pglist=pgdata.getAllpgcolleges();
       	int pgsize=pglist.size();
       	
       	for(int i=0;i<pgsize;i++)
       	{
       	pgcolleges pgcollege=(pgcolleges)pglist.get(i);
    	
    	 %>
    	 <option value="<%=pgcollege.getPgcollegeid() %>"><%=pgcollege.getPgcollegename() %></option>
    	<%}
    	 %>
          </select>
		
		</div>
		</div>				
		<div class="clear"></div>
		<div class="sixcol column">
			<div class="field-wrapper">
			<label>Select Trade</label>	
			<select   name="selectpgtrade" id="int7" >
        <option value="0">Select Trade  </option>
    	   <%
    	   
    	   
    	   tradedatamodel data4=new tradedatamodel();
       	ArrayList list4=data4.getAllgtrades();
       	int size4=list4.size();
       	
       	for(int i=0;i<size4;i++)
       	{
       	gtrades trade=(gtrades)list4.get(i);
    	
    	 %>
    	 <option value="<%=trade.getGtradename() %>"><%=trade.getGtradename() %></option>
    	<%}
    	 %>
          </select>
			
			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
		<div class="field-wrapper">
		<label>Year Of Passing</label>
		<input onkeyup="checkNumeric();"name="pgyop" id="pgyearofpassing" placeholder="Year of Passing" type="text">
			</div></div></div>
		
		<div class="sixcol column">
			<div class="field-wrapper">
			
			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
		
			</div>
		</div>
		
		</div>
		</div>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
<div id=valid>
<button type=submit class="button submit-button left" id="validations">Submit</button>  
<button type=submit class="button submit-button left" id="validations1">Submit</button>
</div>		
	</form>
</div>			</div>
</div>
</body></html>