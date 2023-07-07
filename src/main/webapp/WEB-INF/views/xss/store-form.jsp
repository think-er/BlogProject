<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Stored XSS input form</title>
</head>
<body>
<h1>게시글 작성</h1>
<form method="POST" action="/test/store">
    <label for="content">내용:</label>
    <textarea id="content" name="content"></textarea>
    <br>
    <button type="submit">작성</button>
</form>
</body>
</html>
