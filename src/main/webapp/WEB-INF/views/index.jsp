<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="layout/header.jsp"%>

<div class="container">
<%-- 한 건씩 꺼내서 "board"라는 변수에 집어넣는다 --%>
<c:forEach var="board" items="${boards.content}">
    <div class="card m-2">
        <div class="card-body">
            <%-- getTitle() 이라는 메서드 호출 (내가 이미 만듬) --%>
            <h4 class="card-title">${board.title}</h4>
            <a href="/board/${board.id}" class="btn btn-primary">상세보기</a>
        </div>
    </div>
</c:forEach>
    <ul class="pagination justify-content-center">
        <c:choose>
            <c:when test="${boards.first}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number - 1}">Previous</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number - 1}">Previous</a></li>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${boards.last}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number + 1}">Next</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number + 1}">Next</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>

<%@ include file="layout/footer.jsp"%>



