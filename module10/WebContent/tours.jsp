<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

  <%@ page import="com.msanti16.servlet.constants.ReservationConstants" %>
  <%!
    String[] tourNames = ReservationConstants.TOURS;
    int[] tourId = {0, 1, 2};   
    int selectedTourId = -1;  
    
    void setSelectedTourId(String value){
    	selectedTourId = Integer.parseInt(value);
    }
    
    void getSelectedTourId(){
	 System.out.println(selectedTourId);
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
  
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="./index.jsp">Beartooth Hiking
        Company</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="./index.jsp">Home</a></li>
      <li class="active"><a href="./tours.jsp">Tours</a></li>
    </ul>
  </div>
  </nav>
  


  <div class="container">
    <div class="row">
      <h1>Tours</h1>
      <p>Select tours for more information and reservations</p>
      <div class="col-sm-12">
        <div class="list-group">
          <% for(int i = 0; i < tourNames.length; i++) { %>
            <button 
              data-toggle="modal" 
              data-target="#myModal"
              class="list-group-item"
              onclick='setSelectedTourId(this)'
              id=<%= i %>
            >
            <%= tourNames[i] %>
            </button> 
          <% } %>
        
          NUEVOS
          <a 
            data-toggle="modal" 
            data-target="#modal01"
            class="list-group-item"
            name="Gardiner Lake"
            id="0"
            >
            Gardiner Lake
          </a> 
          <a
            data-toggle="modal" 
            data-target="#modal02"
            class="list-group-item"
            name="Hellroaring Plateau"
            id="1"
            >
            Hellroaring Plateau
          </a> 
          <a
            data-toggle="modal" 
            data-target="#modal03"
            class="list-group-item"
            name="The Beaten Path"
            id="2"
            >
            The Beaten Path
          </a>
          <button
            data-toggle="modal" 
            data-target="#myModal"
            class="list-group-item"
            name="Gardiner Lake"
            id="4"
            >
            Test Modal
          </button>
          
          

          
        </div>
      </div>
    </div>
  </div>

  <div class="modal fade" id="myModal" role="dialog">
    <jsp:include page="components/tourModal.jsp" >
      <jsp:param name="tourId" value="Chaitanya" />
      <jsp:param name="tourName" value="Pratap" />
      <jsp:param name="duration" value="Singh" />
      <jsp:param name="pricePerDay" value="Singh" />
      <jsp:param name="premiumPricePerDay" value="Singh" />
      <jsp:param name="level" value="Singh" />
    </jsp:include>
  </div>
  
  <div class="modal fade" id="modal01" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3>Costs</h3>
          <p>Gardiner Lake</p>
        </div>
        <div class="modal-body">
          <table class="table">
            <thead>
              <tr>
                <th>Duration</th>
                <th>Cost Per Day</th>
                <th>Premium Days</th>
                <th>Level</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>3 or 5 days</td>
                <td>$40.00/day</td>
                <td>$60.00/day</td>
                <td>Intermediate</td>
              </tr>
            </tbody>
          </table>
          <div class="text-right">
            <a type="button" class="btn btn-primary btn-sm"
              href="./reservationGardiner.html">Reserve</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="modal02" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3>Costs</h3>
          <p>Hellroaring Plateau</p>
        </div>
        <div class="modal-body">
          <table class="table">
            <thead>
              <tr>
                <th>Duration</th>
                <th>Cost Per Day</th>
                <th>Premium Days</th>
                <th>Level</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>2,3, or 4 days</td>
                <td>$35.00/day</td>
                <td>$52.50/day</td>
                <td>Easy</td>
              </tr>
            </tbody>
          </table>
          <div class="text-right">
            <a type="button" class="btn btn-primary btn-sm"
              href="./reservationHellroaring.html">Reserve</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="modal03" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3>Costs</h3>
          <p>The Beaten Path</p>
        </div>
        <div class="modal-body">
          <table class="table">
            <thead>
              <tr>
                <th>Duration</th>
                <th>Cost Per Day</th>
                <th>Premium Days</th>
                <th>Level</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>5 or 7 days</td>
                <td>$45.00/day</td>
                <td>$67.50/day</td>
                <td>Difficult</td>
              </tr>
            </tbody>
          </table>
          <div class="text-right">
            <a type="button" class="btn btn-primary btn-sm"
              href="./reservationBeatenPath.html">Reserve</a>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script>
  	function setSelectedTourId(x){
  		<% setSelectedTourId( "1"); %>
  		console.log(x.id);
  		<% getSelectedTourId(); %>
  	}
  </script>
</body>
</html>