<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Конференция</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
    <body>
        <sf:form method="POST" modelAttribute="messageForm>
            <table>
                <tr>
                    <td><sf:input path="text"/></td>
                </tr>
                <tr>
                    <td>
                    </td>
                </tr>
            </table>
        </sf:form>
    </body>
</html>