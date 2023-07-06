<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>

<div class="container">
<%--    우린 이 방식 안쓸거다 JSON으로 모든 데이터를 전송할 것이다. --%>
<%--    <form action="/user/join" method="POST">--  %>
<%--            label for= 다음의 내용과 input의 id 속성의 값이 왜 일치해야하는거지? --%>
    <form>
        <div class="form-group">
            <label for="userName">Username</label>
            <input type="text" class="form-control" placeholder="Enter Username" id="userName">
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" placeholder="Enter email" id="email">
        </div>

    <%--        button이 form 태그 안에 있으면 summit이 되면서 폼 형태를 전송한다.--%>
<%--        <button type="submit" class="btn btn-primary">회원가입 완료</button>--%>
    </form>
    <button id="btn-save" class="btn btn-primary">회원가입 완료</button>
</div>

<script src="js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>



