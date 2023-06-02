<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--c와 fn은 JSTL(JSP Standard Tag Library) 태그 라이브러리를 선언 - JSTL은 그냥 로직을 더 간편하게,단순하게 작성하기 위한 라이브러리--%>


<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/bootstrap.min.css"/>"  rel="stylesheet">
    <%--JSTL의<c:url> 태그를 사용하여 상대 경로로 CSS파일을 가져옴 - <c:url>로 가져오면 다른 경로나 환경에 배포되어도 문제없이 파일을 찾을 수 있다. --%>

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
        <h1 class="display-3">도서 목록</h1>
    </div>
</div>


<div class="container">
    <div class="row" align="center">
        <c:forEach items="${bookList}" var="book">
            <div class="col-md-4">

                <h3 class="col">${book.bkname}</h3> <%--여기정의된 book은 위에 var = book 즉,컨트롤러에서 받아온 bookList이다 --%>
                <p>${book.author}<br>${book.publisher}|${book.releaseDate}</p>
                <p align="left">${fn:substring(book.description,0,100)}</p>
                <p>${book.unitPrice}원</p>

            </div>

        </c:forEach>

    </div>
    <hr>
    <footer>
        <p>&copy; WebMarket</p>
    </footer>


</div>





</body>
</html>
