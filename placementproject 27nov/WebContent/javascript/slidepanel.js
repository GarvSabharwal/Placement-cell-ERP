$(document).ready(function(){

	$(".btn-slide").click(function(){
		$("#panel").slideToggle("slow");
		//$(this).toggleClass("active");
		return false;
	});
	
	$(".btn-slide1").click(function(){
		$("#panel").slideToggle("slow");
		$(this).toggleClass("active"); return false;
	});
	
	 
});