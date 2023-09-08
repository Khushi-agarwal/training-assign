<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="booking">
 <table align="center" bgcolor=lightblue width=50%>
  <tr>
  <th>Booking Id</th>
  <td><input type=text name="bookingId"></td>
  </tr>
   <tr>
  <th>FlightID</th>
  <td><input type=text name="flightId"></td>
  </tr>
  <tr>
  <th>PassengerId</th>
  <td><input type=text name="passengerId"></td>
  </tr>
  <tr>
  <th>First Name</th>
  <td><input type=text name="firstName"></td>
  </tr>
   <tr>
  <th>Last Name</th>
  <td><input type=text name="lastName"></td>
  </tr>
   <tr>
  <th>Mobile</th>
  <td><input type=number name="mobile"></td>
  </tr>
   <tr>
  <th>Email</th>
  <td><input type=text name="email"></td>
  </tr>
   <tr>
  <th>Travel Date</th>
  <td><input type=text name="travelDate"></td>
  </tr>
    <tr>
  <td><input type=submit value=Submit> </td>
    <td><input type=reset value=Cancel> </td>
  </tr>
</table>
</form>
</body>
</html>