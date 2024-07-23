<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--보드 검색--%>
<form style="margin-left: 200px" action="/board/list/boardSearch" method="post">
    <input style="height: 23px" type="text" name="boardSearch" placeholder="게시물을 입력하세요">
    <button style="margin-left: -4px">🧐</button>
</form>
<%--전체 보드--%>
<c:forEach var="board" items="${boards}">
    <table>
        <td>${board.id}</td>
        <td><a href="/board/${board.id}">${board.title}</a></td>
        <td>${board.writer}</td>
        <td>
            <a href="/board/${board.id}/edit">Edit</a>
            <form action="/board/${board.id}/delete" method="post" style="display:inline;">
                <button type="submit">Delete</button>
            </form>
        </td>
    </table>
</c:forEach>
<%--보드 추가--%>
<a href="/board/insert">
    <button type="button">등록</button>
</a>
<br>
<br>
<br>
<br>
<br>
<%--페이지네이션--%>
<c:forEach var="pageNumber" begin="1" end="${totalPages}">
    <a href="/board/list/${pageNumber}">${pageNumber}</a>
</c:forEach>