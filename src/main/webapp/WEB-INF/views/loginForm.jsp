<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Конференция</title>
</head>
    <body>
        <form method="POST">
            <table>
                <tr>
                    <td>Имя:</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td><input type="text" name="password" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>