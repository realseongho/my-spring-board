<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script>
        function showAlert(){
            alert("등록되었습니다.");
        }
    </script>
</head>
<body>
<form action="/board/submit" method="post" >
    <input type="text" name="title" placeholder="제목">
    <input type="hidden" name="writer" value="${writer}">
    <input type="hidden" name="id" value=0>
    <br>
    <br>
    <textarea name="content" rows="4" cols="50" placeholder="본문" style="display: flex"></textarea>
    <button type="submit" onclick="showAlert()">등록</button>
</form>
</body>
</html>