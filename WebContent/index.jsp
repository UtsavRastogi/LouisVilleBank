<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="img/Untitled-1.png">
<link rel="stylesheet" href="css/index.css" type="text/css"> 
<link rel="stylesheet" href="css/animate.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Tangerine">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Louisville Bank</title>
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
<div id="sitelogo">
<img alt="logo" src="img/logo3.png" id="logo1">

</div>

</div>
<div id=animatedText>
<h2 id="demo">At its core, banking is not simply about profit, but about personal relationships. </h2>
</div>

<div id="icons" ><i class="fa fa-linkedin" aria-hidden="true"></i></div>
<div id="icons" ><i class="fa fa-skype" aria-hidden="true"></i></div>
<div id="icons" ><i class="fa fa-youtube-play" aria-hidden="true"></i></div>
<div id="icons" ><i class="fa fa-twitter" aria-hidden="true"></i></div>
<div id="icons" ><i class="fa fa-facebook" aria-hidden="true"></i></div>




<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.lettering.js"></script>
<script type="text/javascript" src="js/jquery.textillate.js"></script>

<script>
$(document).ready(function(){
	  $("#demo").textillate({
		  In:{effect:"fadeInRight"},
			Out:{effect:"fadeOutRight"},
			loop: true
	  });
	
	
});
</script>


</body>
</html>