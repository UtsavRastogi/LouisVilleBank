<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="img/Untitled-1.png">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/welcomeman.css">
<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.structure.min.css" />
	<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.theme.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"> 
	<link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Dancing Script">
     	<link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Tangerine">    

<title>Open Account </title>
<link rel="stylesheet" type="text/css" href="css/createaccount.css">
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


<!-- Open Account  -->
<div id="openacc">
<form action="appServlet13" method="post">
<table style="margin-top: 100px;">
<thead style="font-family: Tangerine;">Create Account</thead>
<tr>
<td>Account Holder Name</td>
<td><input type="text" name="UserName" required placeholder="e.g Utsav"></td></tr>
<tr>
<td>D.O.B</td>
<td><input type="text" name="dob" id="pickdate" required placeholder="YYYY-MM-DD"></td></tr>
<tr>
<td>Email</td>
<td><input type="email" name="email" required placeholder="e.g xyz@abc.com"></td></tr>
<tr>
<td>Type of Account</td>
<td><select name="TypeOfAccount" style="background-color: height: 45px; width: 330px; font-size: 18px;
	margin-bottom: 20px;
	background-color: rgba(255,255,255,0.1);
	border: none;
	border-bottom: 4px groove white;
	border-radius: 10px;
	color: maroon;
	padding-left: 30px;">
<option value="Saving Account">Saving Account </option>
<option value="Current Account">Current Account </option>
<option value="Current Account">Fixed Account </option>
</select></td>
</tr>



<tr>
<td>Address</td>
<td><input type="text" name="address" required placeholder="e.g Mumbai East"></td></tr>

<tr>
<td><input type="submit" value="SUBMIT" id="submitbtn" style="margin-left: 130px;"></td>
<td><input type="reset" value="RESET" id="submitbtn"></td>
</table>

</form>
<div id="nobalance" style="color: white; font-size: 20px;"></div>
</div>
 


<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="jqueryui/jquery-ui.min.js"></script>
<script type="text/javascript">
$("#pickdate").datepicker({changeMonth:true,changeYear:true,showButtonPanel:true,closeText:"Done",currentText:"Current Date"});

</script>

<script type="text/javascript">
function noBalance() {
	document.getElementById('nobalance').innerHTML="Not Enough Balance To Open An Account";
}

function successfull() {
	document.getElementById('nobalance').innerHTML="Account Successfully Created";
}
</script>
<%@include file="footeinner.jsp" %>
</body>
</html>