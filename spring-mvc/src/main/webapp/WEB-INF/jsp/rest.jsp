<%--
  Created by IntelliJ IDEA.
  User: warthur
  Date: 17/7/31
  Time: 下午10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Restful</title>
</head>
<body>
<form action="rest/user/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="put">
</form>

<form action="rest/user/1" method="post">
    <input type="submit" value="post">
</form>

<form action="rest/user/1" method="get">
    <input type="submit" value="get">
</form>

<form action="rest/user/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="delete">
</form>
</body>
</html>
