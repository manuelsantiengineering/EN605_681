<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <style> .nodisplay { display: none; } </style>
  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="./index.jsp">Beartooth Hiking Company</a>
      </div>
      <ul class="nav navbar-nav">
        <li class="${param.isIndex}" ><a href="./index.jsp" >Home</a></li>
        <li  class="${param.isTours}" ><a href="./tours.jsp" >Tours</a></li>
        <li class="${param.isReservation}" ><a href="#" class="${param.hideReservation}" >Reservation</a></li>
      </ul>
    </div>
  </nav>
</html>