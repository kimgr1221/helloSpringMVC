<%--
  Created by IntelliJ IDEA.
  User: USER'
  Date: 2024-04-12
  Time: 오후 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
</head>
<body>
<div class="login-logout">
    <!-- 로그아웃 버튼 (로그인된 사용자에게만 표시) -->
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <p class="logout"><a href="javascript:document.getElementById('logout').submit()">로그아웃</a></p>
    </c:if>
    <!-- 로그인 버튼 (로그아웃 상태에서만 표시) -->
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <p class="login"><a href="${pageContext.request.contextPath}/login">로그인</a></p>
    </c:if>
</div>
<div class="main-links">
    <a href="${pageContext.request.contextPath}/inquiry">학년별 이수 학점 조회</a>
    <a href="${pageContext.request.contextPath}/createoffer">수강 신청하기</a>
    <a href="${pageContext.request.contextPath}/offers">수강 신청 조회</a>
</div>
<form id="logout" action="<c:url value="/logout" />" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>

