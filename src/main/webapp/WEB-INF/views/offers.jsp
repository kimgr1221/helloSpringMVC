<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER'
  Date: 2024-04-12
  Time: 오후 3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>수강 신청 조회</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/offers.css" >
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>년도</th>
        <th>학기</th>
        <th>교과목명</th>
        <th>교과구분</th>
        <th>담당교수</th>
        <th>학점</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="offer" items="${id_offers}">
        <tr>
            <td><c:out value="${offer.year}" /></td>
            <td><c:out value="${offer.semester}" /></td>
            <td><c:out value="${offer.name}" /></td>
            <td><c:out value="${offer.classification}" /></td>
            <td><c:out value="${offer.professor}" /></td>
            <td><c:out value="${offer.credit}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

