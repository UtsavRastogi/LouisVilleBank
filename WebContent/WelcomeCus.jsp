<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><link rel="shortcut icon" href="img/Untitled-1.png">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/welcomeman.css">
<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.structure.min.css" />
	<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.theme.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"> 
	<link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Dancing Script">
          <!-- Start WOWSlider.com HEAD section -->
<link rel="stylesheet" type="text/css" href="engine1/style.css" />
<script type="text/javascript" src="engine1/jquery.js"></script>
<!-- End WOWSlider.com HEAD section -->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Louisville Customer</title>
<link rel="stylesheet" href="css/welcomecustomer.css" type="text/css">
</head>
<body>

<!-- Background Video -->
<div id="backgroundVideo">
<video autoplay loop playsinline>
<source src="video/Wix Website Editor_6.mp4" type="video/mp4">
</video>
</div>
<!-- Header and LOGO -->
<%@include file="CusHeader.jsp" %>
<br>
<!-- Start WOWSlider.com BODY section -->
<div id="wowslider-container1" style="width: 1200px;">
<div class="ws_images"><ul>
		<li><img src="data1/images/moneytransfer.jpg" alt="Money-Transfer" title="Money-Transfer" id="wows1_0"/></li>
		<li><img src="data1/images/money_exchange.jpg" alt="Money-Exchange" title="Money-Exchange" id="wows1_1"/></li>
		<li><img src="data1/images/personal_advice_.jpg" alt="Personal Advice " title="Personal Advice " id="wows1_2"/></li>
		<li><img src="data1/images/easy_debit__credit.jpg" alt="Easy Debit & Credit" title="Easy Debit & Credit" id="wows1_3"/></li>
		<li><img src="data1/images/home_loan.jpg" alt="Home Loan" title="Home Loan" id="wows1_4"/></li>
		<li><a href="http://wowslider.net"><img src="data1/images/845_845_bank_accountm.jpg" alt="http://wowslider.net/" title="Help @home" id="wows1_5"/></a></li>
		<li><img src="data1/images/25000+_atms.jpg" alt="25000+ ATMs" title="25000+ ATMs" id="wows1_6"/></li>
	</ul></div>
<div class="ws_script" style="position:absolute;left:-99%"><a href="http://wowslider.com">bootstrap slider</a> by WOWSlider.com v8.7</div>
<div class="ws_shadow"></div>
</div>	
<script type="text/javascript" src="engine1/wowslider.js"></script>
<script type="text/javascript" src="engine1/script.js"></script>
<!-- End WOWSlider.com BODY section -->
<%@include file="footer.jsp" %>
</body>
</html>