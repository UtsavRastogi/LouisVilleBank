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
	<link rel="stylesheet" href="css/services.css" type="text/css">
	<link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Satisfy">
          <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Cookie">
           <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Playball">
          
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Services</title>
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

<!-- Tabs with accordion -->

<div id="tabs">
  <ul>
    <li><a href="#tab1" style="font-family: Playball;">Online Banking Services</a> </li>      
    <li><a href="#tab2" style="font-family: Playball;">Cash Management Services</a> </li>
     <li><a href="#tab3" style="font-family: Playball;">Payroll Services</a> </li>
  </ul>

<div id="tab1">
  <div id="accordion1">
 <img alt="" src="img/img13.jpg" style="max-width: 850px;"> <h3><a href="" ></a></h3>
 
 <!-- Online Banking Subtab -->
 
 <div id="subtabs">
 <ul>
 <li><a href="#tab11" style="font-family: Playball;">Features</a></li>
 <li><a href="#tab12" style="font-family: Playball;">Additional Services</a></li>
 </ul>
 
 <div id="tab11" style="background-color: white;">
 <h4 style="font-family: Satisfy;">Run your business more efficiently and effectively while keeping your finances simple and secure. Experience the confidence and control of Small Business Online Banking.</h4>
 <h2>Secure, easy access to your account</h2>
 <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;"> &middot; Real-time balance information and pending transactions</p>
  <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;"> &middot; 12 months of sortable online transactions-view check and deposit slips online</p>
  <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; 18 months of online checking and savings statements, plus an option to go paperless layer</p>
   <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Transaction downloads to QuickBooks</p>
   <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Automatic alerts layerFootnote 2 informing you of changes and updates to your account</p>
   <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Self-service account requests, including check and deposit slip reorder and check stop payment</p>
   <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Manage checking, savings, CDs, loans, lines of credit and credit cards</p>
   <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Industry-standard online security</p>
   
   <h2>Online bill payment and transfers</h2>
      <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Send one-time or recurring electronic payments and checks to companies and individuals</p>
       <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Receive bills from some companies electronically and get email notifications when a bill is paid</p>
        <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot; Wire money same day or transfer money next day or third business day inside or outside the U.S.-you control the speed</p>
       <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;">&middot;      Transfer funds to your Bank of America consumer checking account from your checking or brokerage accounts at other financial institutions Footnote

</p>
 </div>
 
 <div id="tab12" style="background-color: white;">
  <h2>Account Management</h2>
 <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;"> &middot; Authorize multiple account users with specified access levels</p>
  <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;"> &middot; Perform all your online banking directly within QuickBooks</p>
  
   <h2>Remote Deposit Online</h2>
   <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;"> &middot; Deposit checks from your home or office</p>
  <p style="font-size: 110%; font-family: Cookie; font-weight: lighter;"> &middot; Receive a complimentary check scanner at no additional charge</p>
  
 </div>
 
 </div>
  </div>
</div>

<div id="tab2">
  <div id="accordion1">
 <img alt="" src="img/img14.jpg" style="max-width: 850px;"> <h3><a href="" ></a></h3>
 
 </div>
  </div>
  
  <div id="tab3">
  <div id="accordion1">
 <img alt="" src="img/img16.png" style="max-width: 850px;"> <h3><a href="" ></a></h3>
 
 </div>
 
  
  </div>
</div>
</div>

<%@include file="footer.jsp" %>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="jqueryui/jquery-ui.min.js"></script>
<script>

$(document).ready(function() {
	  $(document).delegate('.open', 'click', function(event){
	    $(this).addClass('oppenned');
	    event.stopPropagation();
	  })
	  $(document).delegate('body', 'click', function(event) {
	    $('.open').removeClass('oppenned');
	  })
	  $(document).delegate('.cls', 'click', function(event){
	    $('.open').removeClass('oppenned');
	    event.stopPropagation();
	  });
	  
	  $("#accordion1").accordion({heightStyle:"content",collapsible:true, animate:1200});
	    $("#accordion2").accordion({heightStyle:"content",collapsible:true, animate:1200}); 
	    $('#tabs').tabs({collapsible:true,event:"mouseover", animate:1200});
	    $('#subtabs').tabs({collapsible:true,event:"mouseover", animate:1200});
	  
	});

</script>

</body>
</html>