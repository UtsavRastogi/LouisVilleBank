<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="img/Untitled-1.png">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Logs</title>
<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.structure.min.css" />
	<link rel="stylesheet" type="text/css" href="jqueryui/jquery-ui.theme.min.css" />
	     	<link rel="stylesheet" type="text/css"  href="https://fonts.googleapis.com/css?family=Tangerine"> 
<link rel="stylesheet" href="css/viewlogs.css" type="text/css">
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


<div id="main">

<form action="DisplaybankStmtCus.jsp" method="post">
<table>
<tr>
<td>Date Range</td>  </tr>
<tr>
<td>From</td>
<td> <input type="date" name="DateFrom" id="pickdate" value="yyyy-mm-dd"> </td>
<td>To</td>
<td><input type="date" name="DateTo" id="pickdate1" value="yyyy-mm-dd">
</td>
<td><input type="submit" value="Display" id="submitbtn"></td>
</tr>
</table>
</form>
</div>

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="jqueryui/jquery-ui.min.js"></script>
<script type="text/javascript">

</script>
</body>
</html>