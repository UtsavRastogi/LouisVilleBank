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
	<link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Satisfy">
           <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Cookie">
          <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Playball">
         
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Careers</title>
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
<img alt="logo" src="img/img19.jpg" style="width: 940px;">
<h2 style="color: white; font-family: Satisfy; ">At Louisville Bank, you will find a variety of roles available in each of our job areas. Some common examples of those roles are as follows: </h2>
<div id="accordion1">
<h3  style="font-family: Playball;"><a href="#">Administrative / Clerical</a> </h3>
<div>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Administrative Assistant</p> 
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Business Support Manager</p>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Executive Assistant</p>
</div>
<h3  style="font-family: Playball;"><a href="#">Credit / Lending</a> </h3>
<div>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Credit Analyst</p> 
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Underwriter</p>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Fraud Analysts</p>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Credit Services</p>
</div>
<h3  style="font-family: Playball;"><a href="#">Customer Service</a> </h3>
<div>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Call Center</p>    
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Customer Service Representatives</p>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Collections Trust</p>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Services Procurement </p>
</div>
<h3  style="font-family: Playball;"><a href="#">Accounting / Finance</a> </h3>  
<div>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Corporate Finance</p>    
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Finance Reporting</p>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Planning</p>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Business Analysis Accountant & Tax </p>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Business Finance Support</p>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Trust Services Procurement</p>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Investor Relations </p>
</div>

<h3  style="font-family: Playball;"><a href="#">Human Resources</a> </h3>
<div>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Compensation and Benefits</p>    
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Diversity & Inclusion</p>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Generalists</p>
<p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Training/Workforce Analytics, Reporting and Planning </p>
</div>


</div>







</div>

<%@include file="footer.jsp" %>

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="jqueryui/jquery-ui.min.js"></script>
<script>

$(document).ready(function() {
	 
	  
	  $("#accordion1").accordion({heightStyle:"content",collapsible:true, event:"mouseover", animate:1200});
	    $("#accordion2").accordion({heightStyle:"content",collapsible:true, event:"mouseover", animate:1200}); 
	    $('#tabs').tabs({collapsible:true,event:"mouseover", animate:1200});
	    $('#subtabs').tabs({collapsible:true,event:"mouseover", animate:1200});
	  
});
</script>
</body>
</html>