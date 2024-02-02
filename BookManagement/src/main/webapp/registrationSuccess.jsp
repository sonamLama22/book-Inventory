<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css" >

.container{
 margin-top: 20%;
 font-size: 2em;
 text-align: center;
}

.button{
top:50%;
border-radius: 10px;
color: white;
background-color: black;
padding: 6px;
width: 60px;
}

.button:hover{
background-color: #002ead;
transition: 0.7s;
}

</style>
<meta charset="ISO-8859-1">
<title>Registration Success</title>
</head>
<body>

<div class="container" >
	<% String userId = (String)request.getAttribute("userid"); %>

	<% out.println("Welcome, "+ userId); %>
	<br>
	<button onClick="redirectToLogin()" class="button" >Login</button>
</div>

<script>
function redirectToLogin(){
	window.location.href = "Login.jsp";
}
</script>

</body>
</html>