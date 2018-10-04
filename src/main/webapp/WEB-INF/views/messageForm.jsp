<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Конференция</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
<div class="webPage">
    <h1>Новое сообщение</h1>

    <sf:form method="POST" modelAttribute="messageForm">
        <table align="center">
            <tr>
                <td><sf:textarea path="text" cssClass="tweetTextarea"/></td>
            </tr>
        </table>
        <p>
            <input type="submit" name="cancel" value="Отмена"/>
            &nbsp;
            <input type="submit" name="ok" value="OK"/>
        </p>
    </sf:form>
</div>
</body>
</html>