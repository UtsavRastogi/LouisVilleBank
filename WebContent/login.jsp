<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="img/Untitled-1.png">

<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.structure.min.css" />
	<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.theme.min.css" />
	<link rel="stylesheet" href="css/login.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body onload="javascript:back_block();" >
<!-- Background Video -->
<div id="backgroundVideo">
<video autoplay loop playsinline>
<source src="video/Wix Website Editor_6.mp4" type="video/mp4">
</video>
</div>
<!-- Header and LOGO -->
<%@include file="header.jsp" %>
<br><br><br>
<div class="container">
<img alt="customer" src="img/customer.jpg">
<form action="LoginServlet" method="post">
<div class="form-input">
<i class="	fa fa-user-circle-o" style="font-size:25px; color:white; margin-right: 5px;"></i>
<input type="text" name="UserId" placeholder="Enter UserID" required="required" id="UID">
</div>
<div class="form-input">
<i class="fa fa-unlock-alt" style="font-size:25px; color:white; margin-right: 5px;"></i>
<input type="password" name="Password" placeholder="Enter Password" required="required" id="Upass">
</div>
<input type="submit" name="submit" value="LOGIN" id="submitbtn" style="margin-top: 40px;">
</form>
<span id="info" style="color: white; font-size: 20px;"></span>
</div>
<%@include file="footer.jsp" %>


<script type="text/javascript">
function highlightinput() {
	var box1=document.getElementById("UID");
	var box2=document.getElementById("Upass");
	box1.focus();
	box2.focus();
	box1.style.border="solid 2px red";
	box2.style.border="solid 2px red";
	document.getElementById('info').innerHTML="This is invalid UserID or Password.";
}

function Sessionexpired() {
	document.getElementById('info').innerHTML="Session expired ! Please Login.";
}

function noBack() { window.history.forward() }
noBack();
window.onload = noBack;
window.onpageshow = function(evt) { if (evt.persisted) noBack() }
window.onunload = function() { void (0) }

</script>
</body>
</html>