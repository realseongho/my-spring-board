<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>
<h1>회원가입</h1>
<form action="/signup" method="post" >
    <div>ID : <input type="text" name="username"></div>
    <div>PW : <input type="password" name="password"></div>
    <div>PW confirm : <input type="password" name="passwordConfirm"></div><br>
    <div><button type="submit">확인</button></div>
</form>
</body>
</html>