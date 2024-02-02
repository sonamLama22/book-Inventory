<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.bfs45.bookmanagement.model.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="bookServlet" method="post">
<table>
<% Book book= (Book)request.getAttribute("book");%>
<% book.getBookName(); %>

<input type="hidden" name="id" value="<%=book.getBookId() %>">
<tr >
<td>bookname</td>
<td><input type="text" name="bname" value="<%=book.getBookName() %>"></td>

<td>description</td>
<td><input type="text" name="description" value="<%=book.getDescription() %>"></td>

</tr>
<tr>
<td>price</td>
<td><input type="text" name="price" value="<%=book.getPrice()%>"></td>
</tr>




</table>
<input type="submit" value="update" name="update">

</form>
</body>
</html>