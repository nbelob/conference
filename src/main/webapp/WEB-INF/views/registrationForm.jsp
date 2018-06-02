<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Конференция</title>
</head>
    <body>
        <form method="POST" modelAttribute="registrationForm">
            <table align="center">
                <tr>
                    <td>Имя:</td>
                    <td><input type="text" name="username" style="width:200" path="username" /></td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td><input type="text" name="password" style="width:200" path="password" /></td>
                </tr>
                <tr>
                    <td>Повторите пароль:</td>
                    <td><input type="text" name="confPassword" style="width:200" path="confPassword" /></td>
                </tr>
                <tr>
                    <td height="10"></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="right">
                        <input type="submit" value="Зарегистрироваться и войти" style="width:200" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>