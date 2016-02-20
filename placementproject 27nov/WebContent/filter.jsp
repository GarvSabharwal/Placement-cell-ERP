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
						<div class="page-title">
<h1 class="nomargin">Filter Students </h1>
				</div>
				<!-- /page title -->			

	
						</div>
				
		</div>
		<!-- /featured -->

	

	
	
	
<div class="user-description">
	<form style="margin:50px 0px 0px 50px"; action="filtercontroller?id=filter" class="formatted-form" method="POST">
		
		
				
		<div class="clear"></div>
		<div class="sixcol column">
			<div class="field-wrapper">
			<label>Select College</label>	
<select   name="selectcollege" >
        <option value="0">Select college &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </option>
    	   <%
    	   
    	   
    	   collegedatamodel data=new collegedatamodel();
       	ArrayList list=data.getAllgcolleges();
       	int size=list.size();
       	
       	for(int i=0;i<size;i++)
       	{
       	gcolleges college=(gcolleges)list.get(i);
    	
    	 %>
    	 <option value="<%=college.getCollegeid() %>"><%=college.getCollegename() %></option>
    	<%}
    	 %>
          </select>
			</div>								
		</div>
		<div class="sixcol column last">
			<div class="field-wrapper">
		<label>Select Percentage</label>
		<select  name="selectpercentage" >
        <option value="0">Select Total Percentage &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</option>
        <option value="60">Greater Than 60</option>
        <option value="65">Greater Than 65</option>
        <option value="70">Greater Than 70</option>
        </select>
			</div>
		</div>
		
		<div class="sixcol column">
			<div class="field-wrapper">
			<label>Select Backlogs</label>	
		<select   name="selectbacklogs" >
        <option value="-1">Select Number of Backlogs &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp             </option>
        <option value="0">Zero Backlogs</option>
        <option value="1">One Backlogs</option>
        <option value="2">Two Backlogs</option>
        <option value="3">Three Backlogs</option>
        <option value="4">Four Backlogs</option>
        <option value="5">Five Backlogs</option>
        </select>
			</div>								
		</div>
		<div class="sixcol column">
			<div class="field-wrapper">
			<label>Select Trade</label>	
<select   name="selecttrade" >
        <option value="0">Select Trade &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </option>
    	   <%
    	   
    	   
    	   tradedatamodel data2=new tradedatamodel();
       	ArrayList list2=data2.getAllgtrades();
       	int size2=list2.size();
       	
       	for(int i=0;i<size2;i++)
       	{
       	gtrades trade=(gtrades)list2.get(i);
    	
    	 %>
    	 <option value="<%=trade.getGtradeid() %>"><%=trade.getGtradename() %></option>
    	<%}
    	 %>
          </select>

			</div>								
		</div>
		
		<div class="sixcol column last">
			<div class="field-wrapper">
		<label>Select Year Of Passing</label>
		<select   name="selectyearofpassing" >
        <option value="0">Select Year of Passing &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</option>
    	   <%
    	   
    	   
    	   yopdatamodel data1=new yopdatamodel();
       	ArrayList list1=data1.getAllyop();
       	int size1=list1.size();
       	
       	for(int i=0;i<size1;i++)
       	{
       	yop yop=(yop)list1.get(i);
    	
    	 %>
    	 <option value="<%=yop.getYpoid() %>"><%=yop.getYop() %></option>
    	<%}
    	 %>
          </select>
		
		
			</div>
		</div>
				<div class="sixcol column">
			<div class="field-wrapper">
			<label>Select Course</label>	
			<select   name="selectcourse" >
        <option value="0">Select course  or   Degree &nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </option>
    	   <%
    	   
    	   
    	   coursedatamodel data3=new coursedatamodel();
       	ArrayList list3=data3.getAllcourses();
       	int size3=list3.size();
       	
       	for(int i=0;i<size3;i++)
       	{
       	course course=(course)list3.get(i);
    	
    	 %>
    	 <option value="<%=course.getCourseid() %>"><%=course.getCoursename() %></option>
    	<%}
    	 %>
          </select>
			
			</div>								
		</div>		
		
		
		<div class="clear"></div>
<button style="margin-left: 350px"; type=submit class="button submit-button left">Submit</button>  
		
	</form>
</div>





			<!-- /content -->
<jsp:include page="footer.jsp"></jsp:include>