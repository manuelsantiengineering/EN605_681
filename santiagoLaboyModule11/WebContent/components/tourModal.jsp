<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> 
</head>
<body>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h3>Costs</h3>
        <p>${param.tourName}</p>
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
              <td>${param.tourDuration}</td>
              <td>${param.tourCostPerDay}</td>
              <td>${param.tourPremiumCost}</td>
              <td>${param.tourLevel}</td>
            </tr>
          </tbody>
        </table>        
        <div class="text-right">
          <a type="button" class="btn btn-primary btn-sm"
            href="${param.reservationUri}">Reserve</a>
        </div>
      </div>
    </div>
  </div>
  
</body>
</html>