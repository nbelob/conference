<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Конференция</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body onload="document.registrationForm.username.focus();">
<div class="webPage">
    <h1>Регистрация</h1>

    <sf:form method="POST" name="registrationForm" modelAttribute="registrationForm">
        <sf:errors path="*" element="div" cssClass="errors"/>
        <table align="center">
            <tr>
                <td><sf:label path="username" cssErrorClass="error">Имя</sf:label>:</td>
                <td><sf:input path="username" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><sf:label path="password" cssErrorClass="error">Пароль</sf:label>:</td>
                <td><sf:password path="password" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><sf:label path="passwordConfirmation" cssErrorClass="error">Повторите пароль</sf:label>:</td>
                <td><sf:password path="passwordConfirmation" cssErrorClass="error"/></td>
            </tr>
        </table>
        <p>
            <input type="submit" name="registration" value="Зарегистрироваться и войти"/>
            &nbsp;
            <input type="submit" name="cancel" value="Отмена"/>
        </p>
    </sf:form>
</div>
</body>
</html>