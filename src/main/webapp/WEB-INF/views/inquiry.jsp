<%--
  Created by IntelliJ IDEA.
  User: USER'
  Date: 2024-04-13
  Time: 오후 2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Inquiry</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/inquiry.css" >
</head>
<body>
<h1>학기별 이수 학점 및 총 학점</h1>

<table border="1">
    <thead>
    <tr>
        <th>년도</th>
        <th>학기</th>
        <th>취득 학점</th>
        <th>상세보기</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="entry" items="${totalCredits}" varStatus="loop">
        <c:set var="year" value="${entry.key.split('-')[0]}" />
        <c:set var="semester" value="${entry.key.split('-')[1]}" />
        <tr>
            <td><c:out value="${year}" /></td>
            <td><c:out value="${semester}" /></td>
            <td><c:out value="${entry.value}" /></td>
            <td><a href="#" onclick="showDetails('${year}', '${semester}')">링크</a></td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="2">총계</td>
        <td>
            <c:set var="total" value="0" />
            <c:forEach var="entry" items="${totalCredits}">
                <c:set var="total" value="${total + entry.value}" />
            </c:forEach>
            <c:out value="${total}" />
        </td>
        <td></td>
    </tr>
    </tfoot>
</table>

<div id="details"></div>

<script>
    // 서버에서 모든 데이터를 가져와서 JavaScript 객체에 저장합니다.
    var courses = [
        <c:forEach var="course" items="${courses}">
        {
            year: '<c:out value="${course.year}" />',
            semester: '<c:out value="${course.semester}" />',
            name: '<c:out value="${course.name}" />',
            classification: '<c:out value="${course.classification}" />',
            professor: '<c:out value="${course.professor}" />',
            credit: '<c:out value="${course.credit}" />'
        },
        </c:forEach>
    ];

    function showDetails(year, semester) {
        var detailsDiv = document.getElementById("details");
        var detailsHTML = "<h2>" + year + "년도 " + semester + "학기 수강 내역" + "</h2>";

        // 해당 년도와 학기에 해당하는 모든 데이터를 표로 표시합니다.
        detailsHTML += "<table border='1'>";
        detailsHTML += "<thead><tr><th>년도</th><th>학기</th><th>교과목명</th><th>교과구분</th><th>담당교수</th><th>학점</th></tr></thead>";
        detailsHTML += "<tbody>";

        for (var i = 0; i < courses.length; i++) {
            if (courses[i].year === year && courses[i].semester === semester) {
                detailsHTML += "<tr>";
                detailsHTML += "<td>" + courses[i].year + "</td>";
                detailsHTML += "<td>" + courses[i].semester + "</td>";
                detailsHTML += "<td>" + courses[i].name + "</td>";
                detailsHTML += "<td>" + courses[i].classification + "</td>";
                detailsHTML += "<td>" + courses[i].professor + "</td>";
                detailsHTML += "<td>" + courses[i].credit + "</td>";
                detailsHTML += "</tr>";
            }
        }

        detailsHTML += "</tbody>";
        detailsHTML += "</table>";

        detailsDiv.innerHTML = detailsHTML;
    }

</script>


</body>
</html>

