<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Конференция</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
<div class="webPage">
    <sf:form method="POST">
        <table align="center">
            <tr>
                <td>
                    <input type="submit" name="newMessage" value="Написать сообщение"/>
                    &nbsp;
                    <input type="submit" name="newPassword" value="Сменить пароль"/>
                    &nbsp;
                    ${username}
                    &nbsp;
                    <a href="<c:url value="/account/logout" />">Выйти</a>
                </td>
            </tr>
            <tr>
                <td>
                    <table class="messageTable">
                        <c:forEach items="${messageList}" var="message">
                            <tr>
                                <td>
                                    <table>
                                        <tr>
                                            <td>
                                                <span class="userName">${message.userName}</span>
                                                &nbsp;
                                                <span class="small"><fmt:formatDate value="${message.time}"
                                                                                    pattern="dd.MM.yyyy HH:mm:ss"/></span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>${message.text}</td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </table>
    </sf:form>
</div>
</body>
</html>