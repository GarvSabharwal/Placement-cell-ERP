<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<style type="text/css">	
		.slider
		{
			width:5000px;
					}
		.box
		{	
			width:800px;
			overflow:hidden;
		}
		</style>		
		<script type="text/javascript" src="jquery-1.11.2.js"></script>
		<script type="text/javascript">
<%		
        if(request.getParameter("id")!=null)
        {         String str="jkkjk";
        			String str1="fdsfdsfds";
        			String str3=str+str1;
        			System.out.println(str3);
        			
        	%>
        
        	
        	function scroll()
    		{
    		$('.slider').append('<img  src="2.jpg" />')
    		$('.slider').append('<img  src="3.jpg" />')
    		$('.slider').append('<img src="1.jpg" />')
    		$('.slider').append('<img src='+<%request.getParameter("id");%>+'/>')
    			setTimeout(scroll, 3000);
    		}
        		
        	<%}
        	%>
        	
  
        
	
        		
		
		
		

		h=5000;
		a=-800;
		function changeImage()
		{
			h=h+5000;		
			$(".slider").animate({"margin-left":a+"px"}, 2000);
			a=a-800;
			
			if(a<-4000)
			{
			$(".slider").animate({"width":h+"px"});
			}
			
					
						
			
			
		setTimeout(changeImage, 4000);
		}
		$(document).ready(changeImage);
		
		
		</script>
	</head>

 	<body onload="scroll();">
		
		<div class="box">
		
			<div class="slider">
			<img  src="1.jpg" />
			</div>
		</div>
	</body>
</html>