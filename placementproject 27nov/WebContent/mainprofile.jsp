<!--  %if(session.getAttribute("usersession")==null)
{	
	response.sendRedirect("index.jsp");
}%-->
<%@page import="studentmodel.*"%>
<%@page import="projectbean.*"%>
<%@page import="java.util.*"%>
<jsp:include page="loginhead.jsp"></jsp:include>
<p class="slide">
	<a href="#" class="btn-slide"></a>
</p>
<!-- SUBHEADER
================================================== -->

			<div id="subheader" class="subheadertext">
				<div class="row">
					<div class="noslide twelve 

columns">
						<div class="two 

columns">
							<a 

href="#">
								
<% 
String str=request.getParameter("id");
String str1=request.getParameter("id1");
String str2=request.getParameter("id2");
String str3=request.getParameter("id3");
String str4=request.getParameter("id4");
String str5=request.getParameter("id5");
String str6=request.getParameter("id6");
String str7=request.getParameter("id7");
studentdatamodel sdm=new studentdatamodel();
ArrayList list=sdm.getstudentinitaldetails(str);
ArrayList list1=sdm.getallpersonaldetails(str);
studentpersonaldetails spd=new studentpersonaldetails();
studentregistration rs=new studentregistration();
int size=list.size();
int size1=list1.size();
for(int i=0;i<size;i++)
{
rs=(studentregistration)list.get(i);	

}
for(int i=0;i<size1;i++)
{
spd=(studentpersonaldetails)list1.get(i);	

}

%>
<img class="avatar" src="images/parshant.jpg" alt="<%=spd.getFisrstname()%>" title="<%=spd.getFisrstname()%>">
							</a>
						</div>
<div class="five columns noleftmargin">
<p class="bread leftalign">User Name : <%=rs.getUsername()%></p>
						</div>
<div class="five columns">
<p class="bread leftalign">Email Id  : <%=rs.getEmailid() %></p>


</div>
</div>
</div>
</div>
			<!-- CONTENT START
================================================== -->
<div class="row">
	<!--- Sidebar --->
	
		<div class="three columns">
				<div class="box">
					<header>Latest Placement News 
</header>
					<div class="content">
						<div 

class="div"><p>Amazon Visting Piet On:dshjhdsjhdjh</p> </div>
						<div 

class="div"><p></p> <span class="right"></span></div>
						<div 

class="div"><p></p><span class="right"></span></div>
						<div 

class="div"><p></p><span class="right"></span></div>

					</div>
				</div>
				
				<div class="box">
					<header>Notice 

Board</header>
					<div class="content">
				
						<fieldset 

class="nomargin nopad">
                            <legend class="thin">Public Notice</legend>
                            Your are Requested to Update Your Profile Time to Time
							<span 

class="right">Date : 28 sep, 2015</span>
                        </fieldset>
					
						<fieldset 

class="nopad">
                            <legend class="thin">Urgent Notice</legend>
                            No Urgent Notice Till Now
							<span 

class="right">Date : 28 sep, 2015</span>
                        </fieldset>
					
					</div>
				</div>
				
		</div>	<!--- Content --->
	<div class="nine columns">
		<div class="box twelve columns">
        	<div class="maincontent">
	        	<header>STUDENT PROFILE</header>
                <div class="content">
                   	
						<fieldset>
	                    	<legend>General Information</legend>
                            <div class="nine columns">
                            	<div class="row">
                          <div class="three columns"><strong>First Name</strong></div>
                    <div class="one columns">:<%=spd.getFisrstname()%></div>
                    <div class="eight columns"></div>
                                </div>
                                <div class="row">
        <div class="three columns"><strong>Last Name</strong></div>
                                    <div class="one columns">:<%=spd.getLastname()%></div>
                                    <div class="eight columns"></div>
                                </div>

                                <div class="row">
<div class="three columns"><strong>Gender</strong></div>
<div class="one columns">:<%=spd.getGender()%></div>
<div class="eight columns"></div>
                                </div>
                                <div class="row">
   <div class="three columns"><strong>Birth Date</strong></div>
                                    <div class="one columns">:<%=spd.getDateofbirth()%></div>
     <div class="eight columns"></div>
                                </div>
                                <div class="row">
<div class="three columns"><strong>Address</strong></div>
 <div class="one columns">:<%=spd.getAddress()%>, </div>
 <div class="eight columns">&nbsp;&nbsp;&nbsp;<%=spd.getCity()%>-<%=spd.getPincode()%> 
  </div>
                                </div>
                                <div class="row">
 <div class="three columns"><strong>Contact No.</strong></div>
 <div class="one columns">:+91,<%=spd.getMobileno()%></div>
<div class="eight columns"> </div>
                                </div>
                                <div class="row">
       <div class="three columns"><strong>Email</strong></div>
                    <div class="one columns">:<a href="#" 

onclick="window.location='mailto:'<%=rs.getEmailid() %>'; return false;" 

title="Send mail to 

<%=rs.getEmailid() %>"><%=rs.getEmailid() %></a>
                    </div>
         <div class="eight columns"></div>
                                </div>
                            </div>
                            <div class="three columns">
								

<a href="images/<%=rs.getUsername()%>.jpg" class="highslide" 

onclick="return hs.expand(this)">
<img class="twelve" src="images/<%=rs.getUsername()%>.jpg" title="Click to enlarge">
								

</a>
								

<div class="highslide-caption">"images/<%=rs.getUsername()%>.jpg"</div>
                            </div>
  
                           
                        </fieldset>
		                   	
						<fieldset>
	                    	<legend>Accademic</legend>
                            <div class="twelve columns">
                            	
                            	<div class="row">
                                    <div class="two columns"><strong>Course</strong></div>
                                    <div class="one columns">:</div>
                                    <div class="three columns"><%=str2%></div>
                                    <div class="two columns"><strong>Branch</strong></div>
                                    <div class="one columns">:</div>
                                    <div class="three columns"><%=str4%></div>
                                </div>
                                <div class="row">
                                    <div class="two columns"><strong>College</strong></div>
                                    <div class="one columns">:</div>
                                    <div class="three columns"><%=str3%></div>
                                    <div class="two columns"><strong>Percentage</strong></div>
                                    <div class="one columns">:</div>
                                    <div class="three columns"><%=str5%></div>
                                </div>
                            	<div class="row">
                                    <div class="two columns"><strong>Backlogs</strong></div>
                                    <div class="one columns">:</div>
                                    <div class="three columns"><%=str6%></div>
                                    <div class="two columns"><strong>Year of Passing</strong></div>
                                    <div class="one columns">:</div>
                                    <div class="three columns"><%=str7%></div>
                                </div>
                            	
                            </div>
                        </fieldset>
		                   	
					
		                </div>
            </div>
        </div>
	</div>
</div>
<!-- CONTENT END
================================================== -->
<!-- QUOTES
================================================== -->
<div class="row">
	<div class="twelve columns">
		<div id="nav"></div><div style="position: relative;" 

id="testimonials">
			<blockquote style="position: absolute; top: 0px; left: 

0px; display: none; z-index: 3; opacity: 0; width: 868px; height: 151px;">
				<p>"Don't Expect Anything From 

Anyone Because Expectations Always Hurts So Don't Expect And Live HAPPY!  
 " <cite>–Shakespear</cite>
				</p>
			</blockquote>
			<blockquote style="position: absolute; top: 0px; left: 

0px; display: block; z-index: 3; opacity: 0.918764; width: 868px; height: 151px;">
				<p>
					 "A Knwoledgeable person is 

always Identified in Crowd of Millions!" <cite>–GARV SABHARWAL</cite>
				</p>
			</blockquote>
			<blockquote style="position: absolute; top: 0px; left: 

0px; display: block; z-index: 4; opacity: 0.081236; width: 868px; height: 151px;">
				<p>
					 "Be Determined and work 

hard you will get success one day" <cite>–GARV SABHARWAL</cite>
				</p>
			</blockquote>
			<blockquote style="position: absolute; top: 0px; left: 

0px; display: none; z-index: 4; opacity: 0; width: 868px; height: 151px;">
				<p>"Knowledge Defines The Age Of The Person!  
 " <cite>–Rohit Sindher</cite>
				</p>
			</blockquote>
			
		</div>
	</div>
</div>

<!-- CLIENTS 
================================================== -->
<div class="row">
	<div class="twelve columns">
		<div class="image_carousel fitcarousel">
		<div style="display: block; text-align: start; float: none; position: 

relative; top: auto; right: auto; bottom: auto; left: auto; z-index: auto; width: 870px; 

height: 124px; margin: 0px; overflow: hidden;" class="caroufredsel_wrapper"><div 

style="text-align: left; float: none; position: absolute; top: 0px; right: auto; bottom: 

auto; left: 0px; margin: 0px; width: 5046px; height: 124px; z-index: auto;" id="foo2">
				
				
<img src="images/222.txt" alt="" height="140" width="140">
<img src="images/333.txt" alt="" height="140" width="140">
<img src="images/222.txt" alt="" height="140" width="140">
<img src="images/333.txt" alt="" height="140" width="140">
<img src="images/222.txt" alt="" height="140" width="140">
<img src="images/333.txt" alt="" height="140" width="140">
<img src="images/222.txt" alt="" height="140" width="140">
<img src="images/333.txt" alt="" height="140" width="140">
<img src="images/222.txt" alt="" height="140" width="140">
<img src="images/333.txt" alt="" height="140" width="140">
<img src="images/222.txt" alt="" height="140" width="140">
<img src="images/333.txt" alt="" height="140" width="140"></div></div>
			<div class="clearfix">
			</div>
			<a style="display: block;" class="prev" 

id="foo2_prev" href="#"><span>prev</span></a>
			<a style="display: block;" class="next" 

id="foo2_next" href="#"><span>next</span></a>
		</div>
	</div>
</div>



<!-- JAVASCRIPTS 
================================================== -->
<!-- Javascript files placed here for faster loading -->
<script src="javascript/foundation.js"></script> 
<script src="javascript/jquery1.js"></script>
<script src="javascript/jquery_003.js"></script>
<script src="javascript/slidepanel.js"></script>
<script src="javascript/scrolltotop.js"></script>
<script src="javascript/superfish.js"></script>
<script src="javascript/responsivemenu.js"></script>


<!--  div style="padding: 0px; border: medium none; margin: 0px; position: absolute; left: 

0px; top: 0px; width: 100%; z-index: 1001; direction: ltr;" 

class="highslide-container"><a style="position: absolute; top: -9999px; opacity: 0.75; 

z-index: 1;" href="javascript:;" title="Click to cancel" 

class="highslide-loading">Loading...</a><div style="display: none;"></div><div 

style="padding: 0px; border: medium none; margin: 0px; visibility: hidden;" 

class="highslide-viewport highslide-viewport-size"></div><table style="padding: 0px; 

border: medium none; margin: 0px; visibility: hidden; position: absolute; 

border-collapse: collapse; width: 0px;" cellspacing="0"><tbody style="padding: 0px; 

border: medium none; margin: 0px;"><tr style="padding: 0px; border: medium none; 

margin: 0px; height: auto;"><td style="padding: 0px; border: medium none; margin: 

0px; line-height: 0; font-size: 0px; background: 

url(&quot;http://myerp.co.nf/themes/mytheme/highslide/graphics/outlines/rounded-wh

ite.png&quot;) repeat scroll 0px 0px transparent; height: 20px; width: 20px;"></td><td 

style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; 

background: 

url(&quot;http://myerp.co.nf/themes/mytheme/highslide/graphics/outlines/rounded-wh

ite.png&quot;) repeat scroll 0px -40px transparent; height: 20px; width: 

20px;"></td><td style="padding: 0px; border: medium none; margin: 0px; line-height: 

0; font-size: 0px; background: 

url(&quot;http://myerp.co.nf/themes/mytheme/highslide/graphics/outlines/rounded-wh

ite.png&quot;) repeat scroll -20px 0px transparent; height: 20px; width: 

20px;"></td></tr><tr style="padding: 0px; border: medium none; margin: 0px; height: 

auto;"><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; 

font-size: 0px; background: 

url(&quot;http://myerp.co.nf/themes/mytheme/highslide/graphics/outlines/rounded-wh

ite.png&quot;) repeat scroll 0px -80px transparent; height: 20px; width: 

20px;"></td><td class="rounded-white highslide-outline" style="padding: 0px; border: 

medium none; margin: 0px; position: relative;"></td><td style="padding: 0px; border: 

medium none; margin: 0px; line-height: 0; font-size: 0px; background: 

url(&quot;http://myerp.co.nf/themes/mytheme/highslide/graphics/outlines/rounded-wh

ite.png&quot;) repeat scroll -20px -80px transparent; height: 20px; width: 

20px;"></td></tr><tr style="padding: 0px; border: medium none; margin: 0px; height: 

auto;"><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; 

font-size: 0px; background: 

url(&quot;http://myerp.co.nf/themes/mytheme/highslide/graphics/outlines/rounded-wh

ite.png&quot;) repeat scroll 0px -20px transparent; height: 20px; width: 

20px;"></td><td style="padding: 0px; border: medium none; margin: 0px; line-height: 

0; font-size: 0px; background: 

url(&quot;http://myerp.co.nf/themes/mytheme/highslide/graphics/outlines/rounded-wh

ite.png&quot;) repeat scroll 0px -60px transparent; height: 20px; width: 

20px;"></td><td style="padding: 0px; border: medium none; margin: 0px; line-height: 

0; font-size: 0px; background: 

url(&quot;http://myerp.co.nf/themes/mytheme/highslide/graphics/outlines/rounded-wh

ite.png&quot;) repeat scroll -20px -20px transparent; height: 20px; width: 

20px;"></td></tr></tbody></table></div--></body></html>