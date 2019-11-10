<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

  <%@ page import="com.msanti16.servlet.constants.ReservationConstantsArrays" %>
  <%! 
    String dataTargetName(int val){
      return  "#myModal-" + val;
    }
  %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Beartooth Hiking Company</title>
</head>

<body bgcolor="#B0F5B0" text="#000000" link="#0000EE" vlink="#551A8B" alink="#FF0000">
  <jsp:include page="components/navBar.jsp" >
      <jsp:param name="isIndex" value="" />
      <jsp:param name="isTours" value="active" />
      <jsp:param name="isReservation" value="" />
      <jsp:param name="hideReservation" value="hide" />
  </jsp:include>

  <div class="container">
    <div class="row">
      <h1>Tours</h1>
      <p>Select tours for more information and reservations</p>
      <div class="col-sm-12">
        <div class="list-group">
          <% for(int i = 0; i < ReservationConstantsArrays.TOURS.length; i++) { %>
            <button 
              data-toggle="modal" 
              data-target="<%= this.dataTargetName(i) %>"
              class="list-group-item"
            >
            <%= ReservationConstantsArrays.TOURS[i] %>
            </button> 
          <% } %>

        </div>
      </div>
    </div>
  </div>

  <div class="modal fade" id="myModal-0" role="dialog">
    <jsp:include page="components/tourModal.jsp" >
      <jsp:param name="tourName" value="<%= ReservationConstantsArrays.TOURS[0] %>" />
      <jsp:param name="tourDuration" value="<%= ReservationConstantsArrays.DURATION[0] %>" />
      <jsp:param name="tourCostPerDay" value="<%= ReservationConstantsArrays.PRICES[0] %>" />
      <jsp:param name="tourPremiumCost" value="<%= ReservationConstantsArrays.PREMIUM_PRICES[0] %>" />
      <jsp:param name="tourLevel" value="<%= ReservationConstantsArrays.LEVEL[0] %>" />
      <jsp:param name="reservationUri" value="./reservationGardiner.jsp" />
    </jsp:include>
  </div>
  
  <div class="modal fade" id="myModal-1" role="dialog">
    <jsp:include page="components/tourModal.jsp" >
      <jsp:param name="tourName" value="<%= ReservationConstantsArrays.TOURS[1] %>" />
      <jsp:param name="tourDuration" value="<%= ReservationConstantsArrays.DURATION[1] %>" />
      <jsp:param name="tourCostPerDay" value="<%= ReservationConstantsArrays.PRICES[1] %>" />
      <jsp:param name="tourPremiumCost" value="<%= ReservationConstantsArrays.PREMIUM_PRICES[1] %>" />
      <jsp:param name="tourLevel" value="<%= ReservationConstantsArrays.LEVEL[1] %>" />
      <jsp:param name="reservationUri" value="./reservationHellroaring.jsp" />
    </jsp:include>
  </div>
  
  <div class="modal fade" id="myModal-2" role="dialog">
    <jsp:include page="components/tourModal.jsp" >
      <jsp:param name="tourName" value="<%= ReservationConstantsArrays.TOURS[2] %>" />
      <jsp:param name="tourDuration" value="<%= ReservationConstantsArrays.DURATION[2] %>" />
      <jsp:param name="tourCostPerDay" value="<%= ReservationConstantsArrays.PRICES[2] %>" />
      <jsp:param name="tourPremiumCost" value="<%= ReservationConstantsArrays.PREMIUM_PRICES[2] %>" />
      <jsp:param name="tourLevel" value="<%= ReservationConstantsArrays.LEVEL[2] %>" />
      <jsp:param name="reservationUri" value="./reservationBeatenPath.jsp" />
    </jsp:include>
  </div>

</body>
</html>