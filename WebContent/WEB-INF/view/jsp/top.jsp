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
<h1>商品一覧</h1>
<% HashMap itemList = (HashMap)request.getAttribute("itemList"); %>

<form action="./Cart" method="post">
	<table>
		<th>商品名</th><th>値段</th><th>カートに入れる</th>
		<tr><td><input type="hidden" name="name" value="<%= itemList.get("name") %>"><%= itemList.get("name") %></td>
		    <td name="price"><input type="hidden" name="price" value="<%= itemList.get("price") %>"><%= itemList.get("price") %></td><td><input type="submit" value="カートへ"></input></td></tr>
	</table>
</form>

<a href="./Cart">カート画面に遷移</a>

</body>
