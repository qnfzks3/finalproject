
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>

    <link href="<c:url value="/resources/bootstrap.min.css"/>"  rel="stylesheet">
    <title>도서 상세보기</title>


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
            <h1 class="display-3">도서 정보</h1>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <c:forEach items="${bookinfo}" var="bkif">
                    <h3>${bkif.bkname}</h3>
                    <p>${bkif.description}</p>
                    <br>
                    <p><b>도서번호 </b> : <span class="badge badge-info"> ${bkif.bookid}</span></p>
                    <p><b>저자</b> : ${bkif.author}</p>
                    <p><b>출판사</b> : ${bkif.publisher}</p>
                    <p><b>출판일</b> : ${bkif.releaseDate}</p>
                    <p><b>분류</b> : ${bkif.category}</p>
                    <p><b>재고수</b> : ${bkif.unitInStock}</p>
                    <p><b>가격</b> : ${bkif.unitPrice}원</p>
                </c:forEach>
                <br>
                <p><a href="#">도서 주문 &raquo;</a></p>
                <p><a href="<c:url value="/list/booklist?cpg=1" />">도서 목록 &raquo;</a></p>
            </div>
        </div>
        <hr>
        <footer>
            <p>&copy; BookMarket</p>
        </footer>

    </div>


</body>
</html>
