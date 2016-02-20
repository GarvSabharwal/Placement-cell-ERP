
<jsp:include page="head.jsp"></jsp:include>
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
<style type="text/css">	
		.slider
		{
			width:6000px;
			
		}
		.box
		{
			width:1000px;
			overflow:hidden;
		}
		</style>
<script type="text/javascript" src="jquery-1.11.2.js"></script>
<script type="text/javascript">
		a=-140;
		function changeImage()
		{
			
	
		$(".slider").animate({"margin-left":a+"px"}, 2000);
			a=a-142;
			if(a<-2400)
			{
				a=0;
				$(".slider").css({"margin-left":"0px"});
				
			}
			setTimeout(changeImage, 4000);
		}
		$(document).ready(changeImage);
		</script>

<!--Middle Content   Started-->


			

		<div class="featured-content">
		
					<div class="substrate">
				<img src="images/site_bg.jpg" 

class="fullwidth" alt="">			

</div>
						<div 

class="parallax-slider themex-slider">
		<div class="substrate" style="left: 0%;">
		<img src="images/sa.jpg" class="fullwidth" alt="">	</div>
		<ul class="visible" style="width: 6745px; left: -1349px; height: 

485px;"><li style="width: 1349px;">
			<div class="row"><div class="fivecol column" 

style="top: 150.5px;"><h1>The Fragnance of Knowledge Can Be Felt 

EveryWhere</h1><p>Garv Sabharwal</p><a href="register.jsp" target="_self" 

class=" button large primary"><img class="alignnone" alt="" 

src="images/image_4.png">Get Started</a></div><div 

class="sevencol column last" style="top: 0px;"><img src="images/slide_3.png" 

class="alignnone" alt=""></div><div 

class="clear" style="top: 242.5px;"></div></div>
		</li>
					<li class="current" 

style="width: 1349px;">
			<div class="row"><div class="fivecol column" 

style="top: 140.5px;">
<h1>When You Beleive in Yourself You Can Acheive Anything Which You 

Desire</h1>
<p>Garv Sabharwal</p><a href="register.jsp"_self" class=" button large 

primary"><img class="alignnone" alt="" src="images/image_4.png">Get 

Started</a></div><div class="sevencol column last" 

style="top: 0px;">
<img class="alignnone" alt="" src="images/slide_1.png"></div><div class="clear" 

style="top: 

242.5px;"></div></div>
		</li>
					<li class="" style="width: 

1349px;">
			<div class="row"><div class="fivecol column" 

style="top: 150.5px;"><h1>Looking for your first
dream Job?</h1><p></p><a href="register.jsp" target="_self" class=" button large 

primary"><img class="alignnone" alt="" src="images/image_4.png">Get 

Started</a></div><div class="sevencol column last" 

style="top: 0px;"><img src="images/slide_2.png" class="alignnone" alt=""></div><div 

class="clear" 

style="top: 242.5px;"></div></div>
		</li>
	</ul>
		<div class="arrow arrow-left"></div>
	<div class="arrow arrow-right"></div>
		<input type="hidden" class="slider-pause" value="6287">
	<input type="hidden" class="slider-speed" value="1000">
	<input type="hidden" class="slider-effect" value="slide">	
</div>
					
		</div>
		<!-- /featured -->
		<div class="main-content">
			<div class="row"><div class="clear"></div>
								
			<!--  marquee><div class="fourcol column">
		
<h3><img class="alignnone" alt="" src="images/image_1.jpg">AMAZON VISITED 

PIET</h3>
<p>If You Have Potential Than You Will Be The One Who Will Grab This 

Opportunity</p></div><div class="fourcol column">
<h3><img class="alignnone" alt="" src="images/image_2.jpg">Flipkart Visited 

Piet</h3>
<p>Just Be Prepared From First Day So that You Will Be At Flipkart</p></div><div 

class="fourcol column last">
<h3><img class="alignnone" alt="" src="images/image_3.jpg">Infosys Visited 

PIET</h3>
<p>Always Think To Give Your Best Never Think Of Result You Will Get That What 

You Will Deserve</p></div><div class="clear"></div>
<p>&nbsp;</p>

</marquee-->
	
<h1>Our Top Recruiters</h1>
<div  class="fullwidth" style="overflow:hidden;">
		<div class="slider">
		
			<%
    	
			int i;
    	for(i=333;i<350;i++)
    	{
    	
    		%>    		
    <img src="images/<%=i%>.txt" height="140px"width="140px"/>
    	
    	 
    
    	<%}
    	 %>
			<!--  img src="images/222.txt" height="140px"width="140px"/>
			
			<img src="images/222.txt" height="140px"width="140px"/>	
			<img src="images/333.txt" height="140px"width="140px"/>
			<img src="images/222.txt" height="140px"width="140px"/>
			<img src="images/333.txt" height="140px"width="140px"/-->
		</div>
		
		</div>


<p>&nbsp;</p>

<!--div>
  h1>Notification Panel</h1>
<div class="sixcol column">


				<div>
				
					<h2>Placement News</h2>
					<p>
					 <a href>shsjahasjhsaj</a>					
					 </p>
				</div>


</div>
<div class="sixcol column last">

				<div >
				
					<h3>First Work</h3>
					<p>
					 alskdjfl asdkj flaskj dlfj saldkfj lkas djlfj saljd flasj dlf jlsad jfljsaldf jsad jflsadf
					</p>
				</div>


</div>
</div-->
</div>
<div class="clear"></div>
	<marquee><a href="#">hgdjhdjhdsj</a>||<a href="#">hgdjhdjhdsj</a></marquee>	
			
									
			</div>
		
			

<!--Middle Content   End-->
<jsp:include page="footer.jsp"></jsp:include>