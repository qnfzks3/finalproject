<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--c와 fn은 JSTL(JSP Standard Tag Library) 태그 라이브러리를 선언 - JSTL은 그냥 로직을 더 간편하게,단순하게 작성하기 위한 라이브러리--%>



<html>
<head>
    <title>도서 목록</title>
    <link href="<c:url value="/resources/bootstrap.min.css"/>"  rel="stylesheet">
    <%--JSTL의<c:url> 태그를 사용하여 상대 경로로 CSS파일을 가져옴 - <c:url>로 가져오면 다른 경로나 환경에 배포되어도 문제없이 파일을 찾을 수 있다. --%>

    <c:set var="pglink" value="/list/booklist?cpg=" />
    <c:if test="${not empty category}"><%--검색 기능이 포함된 목록 조회--%><%--검색한 주소창에 검색어를 기준으로 접근하자 if문 사용--%>
        <c:set var="pglink" value="/list/booklist/${category}?fkey=${param.fkey}&cpg=" />
    </c:if>
    <%--쿼리스트링 질의 문자열: 주소창에 ?뒤에 나오는 변수만이 param으로 불러오도록 되어있으며 category도 param으로 불러오지 않고 싶다면
      @PathVariable("category")를 안쓰고 그냥 모달엔 뷰에 넣어주면 된다.
     --%>

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
        <c:forEach items="${bklist}" var="book">
            <div class="col-md-4">

                <h3 class="col">${book.bkname}</h3> <%--여기정의된 book은 위에 var = book 즉,컨트롤러에서 받아온 bookList이다 --%>
                <p>${book.author}<br>${book.publisher}|${book.releaseDate}</p>
                <p align="left">${fn:substring(book.description,0,100)}</p>
                <p>${book.unitPrice}원</p>
                <p><a href="<c:url value="/list/bookinfo?id=${book.bookid}"/>" class="btn btn-secondary" role="button">
                    상세정보 보기 &raquo;</a></p>

            </div>
<%--여기 /list/bookinfo?id=${book.bookid} 부분은 버그 래요 신경 안써도 될듯--%>
        </c:forEach>

    </div>
<%--<c:choose>와 <c:when>, <c:otherwise>를 사용하여 조건에 따라 다음 버튼이 활성화되거나 비활성화되도록 처리하였습니다.
    <c:choose>는 여러 개의 조건을 처리하기 위해 사용, <c:when>은 조건이 참인 경우를 처리하고, <c:otherwise>는 그 외의 경우를 처리합니다.--%>

    <div class="row">
        <div class="offset-2 col-8">
            <nav>
                <ul class="pagination justify-content-center">
                    <c:choose>
                        <c:when test="${cpg - 1 gt 0}">
                            <li class="page-item">
                                <a class="page-link" href="${pglink}${cpg-1}">이전</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item disabled">
                                <a class="page-link">이전</a>
                            </li>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach var="i" begin="${stpg}" end="${stpg + 10 - 1}">
                        <c:if test="${i le cntpg}">
                            <c:if test="${i ne cpg}"><li class="page-item"></c:if>
                            <c:if test="${i eq cpg}"><li class="page-item active"></c:if>
                            <a class="page-link" href="${pglink}${i}">${i}</a></li>
                        </c:if>
                    </c:forEach>

                        <c:choose>
                            <c:when test="${(cpg+1) gt cntpg}">
                                <li class="page-item disabled">
                                    <a class="page-link">다음</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item">
                                    <a class="page-link" href="${pglink}${cpg+1}">다음</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                </ul>
            </nav>
        </div>
    </div>





    <hr>
    <footer>
        <p>&copy; WebMarket</p>
    </footer>


</div>





</body>
</html>
