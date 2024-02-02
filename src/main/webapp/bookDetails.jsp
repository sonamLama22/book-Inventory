<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
      <%@ page import="com.bfs45.bookmanagement.model.Book" %>
     <%--  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
  border: 1px solid black;
}
</style>
<meta charset="ISO-8859-1">

</head>
<body>

<form action="bookOrderOrUpdateServlet" method="post">
<table>

<% Set<Book> books= (Set<Book>)request.getAttribute("bookDetails");
for(Book book:books){
%>
<tr >
<td><input type="checkbox" name="listofbookid" value="<%= book.getBookId() %>"></td>
<td><%= book.getBookName() %></td>
</tr>
<%} %>

<br>

</table>
<%String role = (String) request.getAttribute("role"); %>
<% if ("user".equals(role)){ %>
<input type="submit" value="order" name="buttonid">
<% }else if("admin".equals(role)){ %>
<input type="submit" value="update" name="buttonid">
<%} %>
</form>
</body>
</html>