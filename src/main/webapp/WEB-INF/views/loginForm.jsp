<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Конференция</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
</head>
<body>
<div class="webPage">
<h1>Вход</h1>

<form action="<c:url value="/login" />" method="POST">
    <!-- use param.error assuming FormLoginConfigurer#failureUrl contains the query parameter error -->
    <c:if test="${param.error != null}">
        <div class="errors">
            Failed to login.
            <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
            </c:if>
        </div>
    </c:if>
    <!-- the configured LogoutConfigurer#logoutSuccessUrl is /login?logout and contains the query param logout -->
    <c:if test="${param.logout != null}">
        <div class="logout">
            You have been logged out.
        </div>
    </c:if>

    <table align="center">
        <tr>
            <td>Имя:</td>
            <td><input type="text" name="username" autofocus/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password"/></td>
         </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <p>
        <input type="submit" value="Войти"/>
        &nbsp;
        <a href="<c:url value="/account/register" />">Регистрация</a>
    </p>
</form>
</div>
</body>
</html>