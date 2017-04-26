<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="img/Untitled-1.png">
<title>Other Transfer</title>
<link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Tangerine"> 
          <link rel="stylesheet" href="css/othertransferbyman.css" type="text/css">
          
</head>
<body>
<!-- Background Video -->
<div id="backgroundVideo">
<video autoplay loop playsinline>
<source src="video/Wix Website Editor_6.mp4" type="video/mp4">
</video>
</div>

<!-- Header and logo -->
<%@include file="ManHeader.jsp" %>

<!-- Main Part -->
<div id="openacc">
<form action="appServlet5" method="post"><table>
<tr>
<td> A/C No. To Be Withdrawn</td>
<td><input type="text" name="withdrawAcNo"></td></tr>
<tr>
<td> A/C No.To Be Deposited</td>
<td><input type="text" name="depositAcNo"></td></tr>
<tr>
<td>Amount To Be Transfered </td>
<td><input type="text" name="amount"></td></tr>
<tr>
<td><input type="submit" value="Transfer" id="submitbtn"></td></tr>

</table>
</form>
<div id="information" style="font-size: 110%;"></div>
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
function noBal() {
	document.getElementById('information').innerHTML="No Balance.";
}
</script>
<%@include file="footeinner.jsp" %>
</body>
</html>