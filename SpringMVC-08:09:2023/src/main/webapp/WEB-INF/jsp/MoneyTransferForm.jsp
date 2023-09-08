<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
  <form action="transferMoney">
  <table align="center" bgcolor=lightblue width=50%>
  <tr>
  <th>Destination Bank Name</th>
  <td><input type=text></td>
  </tr>
   <tr>
  <th>Destination Bank Branch</th>
  <td><input type=text></td>
  </tr>
   <tr>
  <th>Destination Bank Account No</th>
  <td><input type=text></td>
  </tr>
   <tr>
  <th>Amount to Transfer</th>
  <td><input type=text name="amount"></td>
  </tr>
   <tr>
  <td><input type=submit value=Transfer> </td>
  <td><input type=reset value=Cancel></td>
  </tr>
  
  </table>
  </form>

</body>
</html>