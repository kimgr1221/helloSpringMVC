<%--
  Created by IntelliJ IDEA.
  User: USER'
  Date: 2024-04-12
  Time: 오후 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>수강 신청</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/main.css" >

</head>
<body>
<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
    <table class="formtable">
        <tr>
            <td class="label"> 년도:</td>
            <td><sf:input class="control" type="text" path="year" value="2024"/> <br />
                <sf:errors path="year" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 학기:</td>
            <td><sf:input class="control" type="text" path="semester" value="2"/> <br />
                <sf:errors path="semester" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 교과목명:</td>
            <td><sf:input class="control" type="text" path="name"/> <br />
                <sf:errors path="name" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 교과구분:</td>
            <td><sf:input class="control" type="text" path="classification"/> <br />
                <sf:errors path="classification" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 담당교수:</td>
            <td><sf:input class="control" type="text" path="professor"/> <br />
                <sf:errors path="professor" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 학점:</td>
            <td><sf:input class="control" type="text" path="credit" value=" "/> <br />
                <sf:errors path="credit" class="error" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="신청하기"/> </td>
        </tr>
    </table>
</sf:form>
</body>
</html>
