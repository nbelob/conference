<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Конференция</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
    <body>
        <sf:form method="POST">
            <table align="center">
                <tr>
                    <td></td>
                    <td>${username}</td>
                    <td><a href="/conference/login">Выйти</a></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" name="newMessage" value="Написать сообщение" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <table align="center">
                            <c:forEach items="${messageList}" var="message">
                                <tr>
                                    <td>

                                    </td>
                                </tr>
                                <tr>
                                    <td bgcolor="gray" width="300">
                                        ${message.userName}
                                        &nbsp;
                                        <fmt:formatDate value="${message.time}" pattern="dd.MM.yyyy HH:mm:ss"/>
                                        <br>
                                        ${message.text}
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </table>
        </sf:form>
    </body>
</html>