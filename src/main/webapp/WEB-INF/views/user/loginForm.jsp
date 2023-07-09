<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>

<div class="container">
    <form action="/auth/loginProc" method="post">
        <div class="form-group">
            <%-- label for= 다음의 내용과 input의 id 속성의 값이 왜 일치해야하는거지? --%>
            <label for="userName">Username</label>
            <%-- name이 스프링시큐리티와 연관이 있다. --%>
            <input type="text" name="userName" class="form-control" placeholder="Enter Username" id="userName">
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
        </div>

        <button id="btn-login" class="btn btn-primary">로그인</button>
    </form>
</div>

<%--<script src="js/user.js"></script>--%>
<%@ include file="../layout/footer.jsp"%>



