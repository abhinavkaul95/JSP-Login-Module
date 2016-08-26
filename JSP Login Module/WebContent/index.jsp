<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/style.css" type="text/css">
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("#show_password").mouseover(function(){
		$("#password").attr("type","text");
		$("#show_password").attr("src","img/noshowpass.JPG");
	}).mouseout(function(){
		$("#password").attr("type","password");
		$("#show_password").attr("src","img/showpass.JPG");
	});
});
</script>
</head>
<%
if(session.getAttribute("username") != null){
	session.invalidate();
}
%>
<body>
<form action="ValidateServlet" method="post">
<fieldset>
<legend>Log In</legend>
<div><input class="field inline" type="text" name="username" id="username" placeholder="Enter the username..."></div>
<div><input class="field inline" type="password" name="password" id="password" placeholder="Enter the password..."><img style="height: 25px;" id="show_password" class="inline" src="img/showpass.JPG" alt="image"></div>
<div><input type="submit" value="Log In"></div>
</fieldset>
</form>