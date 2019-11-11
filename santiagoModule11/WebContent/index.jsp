<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
<title>Beartooth Hiking Company</title>
</head>

<body bgcolor="#B0F5B0" text="#000000" link="#0000EE" vlink="#551A8B" alink="#FF0000">
  <jsp:include page="components/navBar.jsp" >
      <jsp:param name="isIndex" value="active" />
  </jsp:include>
  
  <div class="jumbotron text-center">
    <h1>Beartooth Hiking Company (BHC)</h1>
    <h3>Employee Portal</h3>
  </div>

  <div class="container">
    <div class="row">
      <h1>Find a Reservation</h1>
        <form name="form1" method="get" action="/santiagoModule11/findReservation">
          <div class="row">
            <div class="col-sm-12">
              <div class="form-group">
                <label class="control-label" for="date">Start Date</label>
                <div class='input-group date' id='datetimepicker'>            
                  <input class="form-control" name="startDate" id="startDate" placeholder="mm/dd/yyyy" 
                      type="text" onchange="isValidDateFormat()" required/>
                  <span class="input-group-addon"> 
                    <span class="glyphicon glyphicon-calendar" id="dateGlyph"></span> 
                  </span>
                </div>
              </div>   
            </div>
          </div>
          <div class="row">
            <div class="col-sm-12">
              <div class="form-group text-right">
                <input type="submit" class="btn btn-primary btn-lg" value="Search" />
              </div>
            </div>
          </div>
        </form>
    </div>
  </div>
  
  <!-- Error Modal -->
  <div class="modal fade" id="errorModal" role="dialog">
    <div class="modal-dialog">    
          <div class="alert alert-danger alert-dismissible">
            <a class="close" data-dismiss="modal" aria-label="close">&times;</a>
            <p id="modalMessage"></p>
          </div>
    </div>  
  </div>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
  <script type="text/javascript">
    function checkPartyLimits()
    {
    	let value = parseInt(document.getElementById("numOfPeople").value)
    	let max = parseInt(document.getElementById("numOfPeople").max)
    	let min = parseInt(document.getElementById("numOfPeople").min)
      if (value > max){
  	  	document.getElementById("numOfPeople").value = document.getElementById("numOfPeople").max  	  	
        document.getElementById("modalMessage").innerHTML = 
        	"<strong>Error:</strong> Max party size is 10"
        $('#errorModal').modal('show');
      }else if (value < min){
  	  	document.getElementById("numOfPeople").value = document.getElementById("numOfPeople").min  	  	
        document.getElementById("modalMessage").innerHTML = 
        	"<strong>Error:</strong> Min party size is 1"
        $('#errorModal').modal('show')
      }
    }
    function isValidDateFormat(){
    	if(!checkDateFormatIsCorrect()){
  			document.getElementById("startDate").value
    		document.getElementById("modalMessage").innerHTML = 
            	"<strong>Error:</strong> Wrong date format"
        	$('#errorModal').modal('show');
  			document.getElementById("startDate").value = ""
    	}
    }
    function checkDateFormatIsCorrect(){
    	let value = document.getElementById("startDate").value
    	if(value.length === 0){
    		return true
    	}
    	if(value.length > 8){    
        	let array = value.split("/")
        	if(array.length !== 3){
    			return false
        	}
        	if(array[2].length !== 4){
    			return false
        	}
        	console.log(array)
        	for(let i = 0; i < array.length; i++){
        		if(isNaN(array[i]) || parseInt(array[i]) < 1){
        			return false
        		}
        		array[i] = parseInt(array[i])
        	}        	
    	}else{
    		return false
    	}
    	return true
    }
    $(document).ready(function(){
		$('#datetimepicker').datepicker({
			format: 'mm/dd/yyyy',
			todayHighlight: true,
			autoclose: true,
			orientation: 'left'
		})		
	})
  </script>
</body>
</html>