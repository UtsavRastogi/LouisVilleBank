<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="img/Untitled-1.png">

<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.structure.min.css" />
	<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.theme.min.css" />
	<link rel="stylesheet" href="css/contactus.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
<style type="text/css">
input:HOVER {
cursor: pointer;
}
</style>
</head>
<body>

<!-- Background Video -->
<div id="backgroundVideo">
<video autoplay loop playsinline>
<source src="video/Wix Website Editor_6.mp4" type="video/mp4">
</video>
</div>
<!-- Header and LOGO -->
<%@include file="header.jsp" %>
<div id="main">
<div id="accordion">
<h3><a href="#">Contact Us</a>  </h3>

<div><img alt="logo" src="img/img18.png" style="float: left;">
<br>

<h3><span style="font-size: 200%; color: blue;">Email US:</span><br>nodalmanager@louisville.com</h3>
<h3><span style="font-size: 200%; color: blue;">Call US:</span><br>+91 920 380 0000</h3>
</div>
</div>

</div>

<div id="queryForm">
<button id="query" ><span id="span1">Have any QUERY ?</span><span id="span2" hidden>Click Me</span></button>
<div id="box" hidden>
<form action="#" method="post" id="queryForm">
<table>
<tr>
<td>Name</td><td> <input type="text" name="name" required style="background: none; border: none; border-bottom: 2px groove orange; border-radius: 10px; "></td></tr>
<tr>
<td>E-Mail</td><td> <input type="email" name="email" required style="background: none; border: none; border-bottom: 2px groove orange; border-radius: 10px; "></td></tr>
<tr>
<td>Comment </td><td> <textarea rows="10" cols="24" name="comment" required style="background: none; border: none; border-bottom: 2px groove orange; border-radius: 10px; "></textarea> </td></tr>
<tr>
<td><input type="submit" value="submit" style="background-color: red; color: white; border: none; border-bottom: 3px double black; border-radius: 10px; ">  </td></tr>
</table>
</form>
</div>
</div>


<%@include file="footer.jsp" %>

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="jqueryui/jquery-ui.min.js"></script>
<script type="text/javascript" src="jqueryui/validator.js"></script>
<script>

$(document).ready(function() {
	
	  
	  $("#accordion").accordion({collipsible:true,event:"mouseover"});
	  
	  
	  $("#query").hover(function(){
			$("#span1").hide();
			$("#span2").show();},
			function(){
				$("#span2").hide();
				$("#span1").show();
			});
	  
	  $("button").click(function(){
			
			$("#box").dialog({title:"Query Desk",draggable:false,resizable:false,height:500,width:600,show:1500,show:"explode",hide:"explode",modal:true});
			
		});

});</script>


</body>
</html>