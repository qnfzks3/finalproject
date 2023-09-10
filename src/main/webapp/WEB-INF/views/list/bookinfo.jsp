
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>

    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
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

                        <img src="<c:url value='/image/${bookinfo.imagePath}' />" alt="no image" />

                        <h3>${bookinfo.bkname}</h3>
                        <p>${bookinfo.description}</p>
                        <br>
                        <p><b>도서번호 </b> : <span class="badge badge-info"> ${bookinfo.bookid}</span></p>
                        <p><b>저자</b> : ${bookinfo.author}</p>
                        <p><b>출판사</b> : ${bookinfo.publisher}</p>
                        <p><b>출판일</b> : ${bookinfo.releaseDate}</p>
                        <p><b>분류</b> : ${bookinfo.category}</p>
                        <p><b>재고수</b> : ${bookinfo.unitsInStock}</p>
                        <h4>가격 : ${bookinfo.unitPrice}원</h4>
                    </div>

                <br>
                <p><a href="#" class="btn btn-primary">도서 주문 &raquo;</a></p>
                <p><a href="<c:url value="/list/booklist?cpg=1 "/>" class="btn btn-secondary">도서 목록 &raquo;</a></p>
        </div>
        <hr>
        <footer>
            <p>&copy; BookMarket</p>
        </footer>

    </div>


</body>
</html>
