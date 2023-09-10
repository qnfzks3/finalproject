<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
  <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
  <title>도서 등록</title>
</head>
<body>
<nav class="navbar navbar-expand  navbar-dark bg-dark">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="/bookindex">The bookshop</a>
    </div>
  </div>
</nav>
<div class="jumbotron">
  <div class="container">
    <h1 class="display-3">도서 등록</h1>
  </div>
</div>

<div class="container">
  <div class="float-right">
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
      <input type="submit" class="btn btn-sm btn-success" value="Logout" />
    </form:form>
  </div>
  <br><br><%--action="./add?${_csrf.parameterName}=${_csrf.token}"은 폼 데이터를 서버로 제출할 때 요청을 보낼 경로를 지정 csrf토큰은 보안 강화역할-주소 다르게--%>
  <form:form modelAttribute = "newbook"
             action="./add?${_csrf.parameterName}=${_csrf.token}"
             class="form-horizontal"
             enctype="multipart/form-data" > <%--enctype="multipart/form-data"은 폼 데이터에 파일 업로드가 포함되어 있음, 이는 폼에서 파일을 전송하는 경우에 필요한 설정입니다.--%>
    <fieldset>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >도서명</label>
        <div class="col-sm-3">
          <form:input  path="bkname" name="bkname" id="bkname" class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >가격</label>
        <div class="col-sm-3">
          <form:input  path="unitPrice" name="unitPrice" id="unitPrice" class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >저자</label>
        <div class="col-sm-3">
          <form:input  path="author" name="author" id="author" class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >상세정보</label>
        <div class="col-sm-5">
          <form:textarea  path="description" name="description" id="description" cols="50" rows="2" class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >출판사</label>
        <div class="col-sm-3">
          <form:input  path="publisher" name="publisher" id="publisher" class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >분야</label>
        <div class="col-sm-3">
          <form:input path="category" name="category" id="category" class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >재고수 </label>
        <div class="col-sm-3">
          <form:input path="unitsInStock" name="unitsInStock" id="unitsInStock" class="form-control"/>
        </div>
      </div>

      <div class="form-group row">
        <label class="col-sm-2 control-label" >상태</label>
        <div class="col-sm-3">
          <form:radiobutton path="cobd" value="New" /> New
          <form:radiobutton path="cobd" value="Old" /> Old
          <form:radiobutton path="cobd" value="E-Book" />E-Book
        </div>
      </div>

      <div class="form-group row">
        <label class="col-sm-2 control-label">도서 이미지</label>
        <div class="col-sm-7">
          <form:input path="bookImage" type="file" class="form-control" />  <%--type="file"  그리고 Book에 지정한 변수 bookImage 에 파일을 넣어라 --%>
        </div>
      </div>


      <div class="form-group row">
        <div class="col-sm-offset-2 col-sm-10" >
        <input type="submit" id="writebtn" class="btn btn-primary"  value ="등록"/> <%--submit 으로 제출--%>
      </div>
      </div>
    </fieldset>
  </form:form>
  <hr>
  <footer>
    <p>&copy; BookMarket</p>
  </footer>
</div>
</body>
</html>