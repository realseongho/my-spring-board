<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script>
        function showAlert(){
            alert("수정되었습니다.");
        }
    </script>
    <title>Edit</title>
</head>
<body>
<form action="/board/submit" method="post" >
    <input type="text" name="title" value="${board.title}">
    <input type="hidden" name="writer" value="${board.writer}">
    <input type="hidden" name="id" value="${board.id}">
    <br>
    <br>
    <textarea name="content" rows="4" cols="50" style="display: flex">${board.content}</textarea>
    <button type="submit" onclick="showAlert()">수정</button>
</form>
</body>
</html>