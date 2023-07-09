<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="layout/header.jsp"%>

<%-- 한 건씩 꺼내서 "board"라는 변수에 집어넣는다 --%>
<c:forEach var="board" items="${boards}">
<div class="container">
    <div class="card m-2">
        <div class="card-body">
            <%-- getTitle() 이라는 메서드 호출 (내가 이미 만듬) --%>
            <h4 class="card-title">${board.title}</h4>
            <a href="#" class="btn btn-primary">상세보기</a>
        </div>
    </div>
</div>
</c:forEach>
<%@ include file="layout/footer.jsp"%>



