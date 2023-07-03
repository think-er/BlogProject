<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>

<div class="container">
    <form action="/action_page.php">
        <div class="form-group">
<%--            label for= 다음의 내용과 input의 id 속성의 값이 왜 일치해야하는거지? --%>
            <label for="userName">Username</label>
            <input type="text" class="form-control" placeholder="Enter Username" id="userName">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" placeholder="Enter email" id="email">
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password">
        </div>

        <button type="submit" class="btn btn-primary">회원가입 완료</button>
    </form>
</div>

<%@ include file="../layout/footer.jsp"%>



