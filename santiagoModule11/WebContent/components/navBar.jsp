<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <style> .nodisplay { display: none; } </style>
  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="./index.jsp">BHC Employee Portal</a>
      </div>
      <ul class="nav navbar-nav">
        <li class="${param.isIndex}" ><a href="./index.jsp" >Reservations</a></li>
      </ul>
    </div>
  </nav>
</html>