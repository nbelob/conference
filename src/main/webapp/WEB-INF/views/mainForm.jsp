<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Конференция</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
    <body>
            <table align="center">
                <tr>
                    <td></td>
                    <td>${username}</td>
                    <td><a href="/conference/login">Выйти</a></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Написать сообщение" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <table align="center">
                            <c:forEach items="${messages}" var="message">
                                <tr>
                                    <td>
                                        <p>Сообщение</p>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </table>
    </body>
</html>