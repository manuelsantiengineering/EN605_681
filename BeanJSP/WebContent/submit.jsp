<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="address" class="com.rbevans.Address" />
<jsp:setProperty
     name="address"
     property="street"
     param="street" />
<jsp:setProperty
     name="address"
     property="city"
     param="city" />
<jsp:setProperty
     name="address"
     property="state"
     param="state" />
<jsp:setProperty
     name="address"
     property="zip"
     param="zip" />
     
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thanks!</title>
</head>
<body>
     <h2>Thanks, you entered...</h2>
        Address: <jsp:getProperty name="address" property="street" /> <br />
        City: <jsp:getProperty name="address" property="city" /> <br />
        State: <jsp:getProperty name="address" property="state" /> <br />
        Zip: <jsp:getProperty name="address" property="zip" /> <br />
</body>
</html>