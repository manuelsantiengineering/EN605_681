<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> 
  
<title>Beartooth Hiking Company</title>
</head>

<body bgcolor="#B0F5B0" text="#000000" link="#0000EE" vlink="#551A8B" alink="#FF0000">
  <jsp:include page="components/navBar.jsp" >
      <jsp:param name="isIndex" value="active" />
      <jsp:param name="isTours" value="" />
      <jsp:param name="isReservation" value="" />
      <jsp:param name="hideReservation" value="hide" />
  </jsp:include>
  
  <div class="jumbotron text-center">
    <h1>Beartooth Hiking Company (BHC)</h1>
    <p>Find great hiking trips!</p>
  </div>



  <div class="container">
    <div class="row">
      <div class="col-sm-4">
        <img src="./images/001_womanHiker.jpg" alt="New Horizons"
          width="350" height="220" />
        <h3>Explore New Horizons</h3>
        <p>Multiple adventures to choice from.</p>
      </div>
      <div class="col-sm-4">
        <img src="./images/002_freedom.jpg" alt="Freedom" width="350"
          height="220" />
        <h3>Enjoy Freedom</h3>
        <p>Incredible panoramic views.</p>
      </div>
      <div class="col-sm-4">
        <img src="./images/003_groupselfie.jpg" alt="Sharing"
          width="350" height="220" />
        <h3>Share it with Friends</h3>
        <p>Great trips to enjoy with friends.</p>
      </div>
      <div class="row">
        <div class="col-sm-12">
          <ul class="pager">
            <li class="next"><a
              href="https://www.fs.usda.gov/recarea/shoshone/recarea/?recid=80899">More
                information</a></li>
          </ul>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-12">
          <ul class="pager">
            <p>
              To find out more about prices and reservations click on
              our <a href="./tours.jsp">Tours</a> link.
            </p>
          </ul>
        </div>
        <div class="col-sm-12">
          <p class="text-right">Created by: Manuel E. Santiago Laboy
          </p>
        </div>
      </div>
    </div>
  </div>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>  
</body>
</html>