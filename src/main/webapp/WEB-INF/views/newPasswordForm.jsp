<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Конференция</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
    <body>
        <sf:form method="POST" modelAttribute="newPasswordForm">
            <sf:errors path="*" element="div" cssClass="errors"/>
            <table align="center">
                <tr>
                    <td><sf:label path="password" cssErrorClass="error">Пароль</sf:label>:</td>
                    <td><sf:password path="password" cssErrorClass="error"/></td>
                </tr>
                <tr>
                    <td><sf:label path="confPassword" cssErrorClass="error">Повторите пароль</sf:label>:</td>
                    <td><sf:password path="confPassword" cssErrorClass="error"/></td>
                </tr>
                <tr>
                    <td height="10"></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="right">
                        <input type="submit" name="ok" value="OK" style="width:200" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td align="right">
                        <input type="submit" name="cancel" value="Отмена" style="width:200" />
                    </td>
                </tr>
            </table>
        </sf:form>
    </body>
</html>