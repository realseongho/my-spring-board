<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body style="padding-left: 10px;">
    <span>${board.id}</span>
    <div style="display: flex;">
        <h1 style="font-size: 30px;">${board.title}&nbsp;&nbsp;</h1>
        <p style="padding-top: 20px;">${board.writer}</p>
    </div>
    <p>${board.content}</p>
<%--댓글--%><%--댓글--%><%--댓글--%><%--댓글--%><%--댓글--%><%--댓글--%><%--댓글--%><%--댓글--%>
    <c:forEach var="comment" items="${comments}">
        <table>
            <td>${comment.content}</td>
            <td style="font-size: 20px">${comment.username}</td>
<%--                        <td>--%>
<%--                            <a href="/board/${board.id}/${comment.id}/edit">Edit</a>--%>
<%--                            <form action="/board/${board.id}/${comment.id}/delete" method="post" style="display:inline;">--%>
<%--                                <button type="submit">Delete</button>--%>
<%--                            </form>--%>
<%--                        </td>--%>
        </table>
    </c:forEach>
    <form action="/board/${board.id}/submit" method="post" >
        <textarea name="content" rows="4" cols="50" style="display: flex"></textarea>
        <button type="submit">등록</button>
    </form>
</body>
</html>