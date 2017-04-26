<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="shortcut icon" href="img/Untitled-1.png">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Own Transfers</title>
<link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Tangerine"> 
          <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=  Dancing Script">
    
    <link rel="stylesheet" href="css/owntransferbycus.css" type="text/css">
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


<!-- main part -->
<div id="openacc">
<form id="TransactionForm"  method="post">
<table>
<tr><td>Account number</td>
<td> <input type="text" name="AccountNo" width="20" required placeholder="LVC..."></td></tr>
<tr>
<td>Amount</td>
<td><input type="text" name="Amount" width="20" required placeholder="e.g  28377"></td></tr>
<tr>
<td><button id="btn" name="Transaction" value="DebitFrom" type="submit" onclick="callServlet()" >Debit From</button></td>
<td><button id="btn" name="Transaction" value="CreditTo" type="submit" onclick="callServlet()" >Credit To</button></td>
</tr>


</table>
</form>
<span id="information" style="color: white; font-size: 20px;"></span>
</div>

<!-- Search accounts -->
<div id="openacc" style="height: auto; font-size: 18px;">
<h1>Search Account No</h1>  
<h3>Enter Name</h3>
<form name="vinform" >  
<input type="text" name="name" onkeyup="searchInfo()">  
</form>  
  
<span id="mylocation"></span>  
</div>

<script type="text/javascript">
function callServlet() {
	document.getElementById("TransactionForm").action="/LouisBank/appServlet14";
	document.getElementById("TransactionForm").submit();
}
</script>
<script type="text/javascript">
var request=new XMLHttpRequest();  
function searchInfo(){  
var name=document.vinform.name.value;  
var url="index1.jsp?val="+name;  
  
try{  
request.onreadystatechange=function(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById('mylocation').innerHTML=val;  
}  
}//end of function  
request.open("GET",url,true);  
request.send();  
}catch(e){alert("Unable to connect to server");}  
}  
</script>
<script type="text/javascript">
function success() {
	document.getElementById('information').innerHTML="Transaction successful.";
}

</script>

<script type="text/javascript">
function noBalance() {
	document.getElementById('information').innerHTML="Insufficient Balance.";
}

</script>

<%@include file="footeinner.jsp" %>
</body>

</html>