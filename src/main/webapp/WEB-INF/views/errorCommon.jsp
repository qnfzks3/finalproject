<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link href="/resources/css/bootstrap.min.css">
    <title>오류 페이지 공통 예외처리</title>
</head>
<body>
    <nav class="navbar navbar-expand navbar-dark bg-dark">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="/bookindex">The bookshop</a>

            </div>
        </div>
    </nav>
    <div class="jumbotron">
        <div class="container">
            <h2 class="alert alert-danger">페이지 오류입니다.</h2>

        </div>
    </div>
    <div class="container">
        <p>${exception}</p>
    </div>
    <div class="container">
        <p>
            <a href="<c:url value="/list/booklist?cpg=1 "/>" class="btn btn-secondary">도서 목록 &raquo;</a>
        </p>
    </div>



</body>
</html>
