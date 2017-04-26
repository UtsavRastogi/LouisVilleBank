<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="img/Untitled-1.png">
<link rel="stylesheet" href="css/contactus.css" type="text/css">
 <style>
      #map {
        height: 400px;
        width: 1300px;
       margin-left:30px;
       margin-right: 10px;
       clear: both;
       border-color: maroon;
       border-width: 5px;
       border-radius: 10px;
       }
    </style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locate Us</title>
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

 <div id="map"></div>
    <script>
      function initMap() {
        var uluru = {lat: 38.328732, lng: -85.764771};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 8,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCryaAywH00D08i_eHABbnOwUbsZPNHUik&callback=initMap">
    </script>

<%@include file="footer.jsp" %>
</body>
</html>