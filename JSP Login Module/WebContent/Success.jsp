<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<% session.setAttribute("username", request.getParameter("username")); %>
<p>Thank you for logging in, Mr <%= session.getAttribute("username") %></p>
<a href="index.jsp">Log out</a>
</body>
</html>