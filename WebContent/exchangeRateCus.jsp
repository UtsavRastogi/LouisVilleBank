<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="img/Untitled-1.png">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exchange Rate</title>
<link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Tangerine"> 
<link rel="stylesheet" type="text/css" href="css/exchangerate.css">
</head>
<body>

<!-- Background Video -->
<div id="backgroundVideo">
<video autoplay loop playsinline>
<source src="video/Wix Website Editor_6.mp4" type="video/mp4">
</video>
</div>

<!-- Header and logo -->
<%@include file="CusHeader.jsp" %>

<div id="exchange">
<form action="appServlet16" method="post">
<table>
<tr>
<td>Enter Amount</td>
<td><input type="text" name="amount" required placeholder="e.g 7383"></td></tr>
<tr>
<td>From</td>
<td><select name="curremcyFrom" style="background-color: height: 45px; width: 330px; font-size: 18px;
	margin-bottom: 20px;
	background-color: rgba(255,255,255,0.1);
	border: none;
	border-bottom: 4px groove white;
	border-radius: 10px;
	color: maroon;
	padding-left: 30px;">
<option>Australian Dollar (AUD)</option>
<option>Euro (EUR)</option>
<option>British Pound Sterling (GBP) </option>
<option>US Dollar (USD)</option>
<option>Indian Rupee(RS)</option>
</select></td></tr>
<tr>
<td>To</td>
<td><select name="currencyTo" style="background-color: height: 45px; width: 330px; font-size: 18px;
	margin-bottom: 20px;
	background-color: rgba(255,255,255,0.1);
	border: none;
	border-bottom: 4px groove white;
	border-radius: 10px;
	color: maroon;
	padding-left: 30px;">
<option>Indian Rupee(RS)</option>
<option>Australian Dollar (AUD)</option>
<option>Euro (EUR)</option>
<option>British Pound Sterling (GBP) </option>
<option>US Dollar (USD)</option>

</select></td></tr>
<tr>
<td><input type="submit" value="Convert" id="submitbtn"></td></tr>
</table>
</form>

<span id="exchangeAmount"></span>
</div>
<%@include file="footeinner.jsp" %>
<script type="text/javascript">
</script>
<script type="text/javascript">
function result( amount){
	document.getElementById('exchangeAmount').innerHTML=amount;
}
</script>
</body>
</html>