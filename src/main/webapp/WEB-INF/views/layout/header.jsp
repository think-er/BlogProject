<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

    <%--스크립트는 헤더에 적지않고 바디의 마지막에 가장 가까운 부분에 넣는다.
    이유는 JS는 인터프리터 언어이기 때문이다. --%>
    <%--다시 위로 올리는 이유는 JQuery 관련 스크립트를 실행하기 위해서 초기에 이 스크립트문이 필요하기 때문--%>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="/blog">thinker</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
<%--                경로에 대한 문제를 좀 공부해야할 필요 있음--%>
                <a class="nav-link" href="/blog/user/loginForm">로그인</a>
            </li>
            <li class="nav-item">
<%--                나는 user라는 폴더에 접근해서 그 폴더 안에 있는 joinForm 파일을 가져오겠다 라는 것--%>
                <a class="nav-link" href="/blog/user/joinForm">회원가입</a>
            </li>
        </ul>
    </div>
</nav>
<br/>
