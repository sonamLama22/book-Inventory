<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css" >

.box{
 margin-top: 10%;
 text-align: center;
}

.container{
display: flex;
justify-content: center;
align-items: center;
}

input[type=text], input[type=password]{
box-sizing: border-box;
padding: 12px 20px;
border: 2px solid #ccc;
}

h4{
color: blue; 
margin-right:5px; 
font-size:20px;
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
<title>Login</title>
</head>
<body>

<div class="box">
<form action="login" method="post">

<div class="container">
<h4>Username</h4>
<input type="text" name = "username">
</div>

<div class="container">
<h4>Password</h4>
<input type="password" name ="password">
</div>

<div class="container">
<button class="button" >Login</button>
</div>

</form>
</div>

</body>
</html>