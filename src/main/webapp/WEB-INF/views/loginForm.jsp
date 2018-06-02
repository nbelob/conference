<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Конференция</title>
</head>
    <body>
        <form method="POST" modelAttribute="loginForm">
            <table align="center">
                <tr>
                    <td>Имя:</td>
                    <td><input type="text" name="username" path="username" /></td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td><input type="text" name="password" path="password" /></td>
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
        </form>
    </body>
</html>