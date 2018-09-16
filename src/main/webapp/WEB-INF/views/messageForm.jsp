<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Конференция</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
    <body>
        <sf:form method="POST" modelAttribute="messageForm">
            <table align="center">
                <tr>
                    <td><sf:textarea path="text"/></td>
                </tr>
                <tr>
                    <td height="5"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" name="cancel" value="Отмена" style="width:100" />
                    </td>
                    <td>
                        <input type="submit" name="ok" value="OK" style="width:100" />
                    </td>
                </tr>
            </table>
        </sf:form>
    </body>
</html>