<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Конференция</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
    <body>
        <sf:form method="POST" modelAttribute="loginForm">
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
                    <td height="10"></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="right">
                        <input type="submit" name="login" value="Войти" style="width:100" />
                    </td>
                </tr>
                <tr>
                    <td height="5"></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="right">
                        <input type="submit" name="registration" value="Регистрация" style="width:100" />
                    </td>
                </tr>
            </table>
        </sf:form>
    </body>
</html>