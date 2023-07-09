<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>

<div class="container">

    <form>
        <div class="form-group">
            <%-- label for= 다음의 내용과 input의 id 속성의 값이 왜 일치해야하는거지? --%>
            <label for="title">Title</label>
            <%-- name이 스프링시큐리티와 연관이 있다. --%>
            <input type="text" class="form-control" placeholder="Enter title" id="title">
        </div>

        <div class="form-group">
            <label for="content">Comment:</label>
            <textarea class="form-control summernote" rows="5" id="content"></textarea>
        </div>
    </form>
    <button id="btn-save" class="btn btn-primary">저장</button>
</div>

<script>
    $('.summernote').summernote({
        placeholder: 'Enter Content',
        tabsize: 2,
        height: 300
    });
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>



