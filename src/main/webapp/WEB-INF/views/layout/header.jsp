<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- 인증이 되었는지 안되었는지를 확인할 수 있다. --%>
<%-- 문서를 찾는 능력도, 읽는 능력도 중요할 것 같다...--%>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>thinker's blog</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

    <%--스크립트는 헤더에 적지않고 바디의 마지막에 가장 가까운 부분에 넣는다.
    이유는 JS는 인터프리터 언어이기 때문이다. --%>
    <%--다시 위로 올리는 이유는 JQuery 관련 스크립트를 실행하기 위해서 초기에 이 스크립트문이 필요하기 때문--%>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%--<h1>${principal}</h1>--%>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="/">thinker</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">

        <c:choose>
            <%-- 세션이 null이거나 비어있다면 ? --%>
            <c:when test="${empty principal}">
                <ul class="navbar-nav">
                    <li class="nav-item">
                            <%-- 경로에 대한 문제를 좀 공부해야할 필요 있음--%>
                        <a class="nav-link" href="/auth/loginForm">로그인</a>
                    </li>
                    <li class="nav-item">
                            <%-- 나는 user라는 폴더에 접근해서 그 폴더 안에 있는 joinForm 파일을 가져오겠다 라는 것--%>
                        <a class="nav-link" href="/auth/joinForm">회원가입</a>
                    </li>
                </ul>
            </c:when>
            <%-- 그렇지 않다면? --%>
            <c:otherwise>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/board/form">글쓰기</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/form">회원정보</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">로그아웃</a>
                    </li>
                </ul>
            </c:otherwise>
        </c:choose>
    </div>
</nav>
<br/>
