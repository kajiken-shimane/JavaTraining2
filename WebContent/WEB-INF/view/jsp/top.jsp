<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Top</title>
</head>
<body>
<% HashMap itemList = (HashMap)request.getAttribute("itemList"); %>
Name <%= itemList.get("name") %><br>
price <%= itemList.get("price") %><br>
</body>
