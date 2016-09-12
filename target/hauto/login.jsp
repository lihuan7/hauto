<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<form method="POST" action="j_security_check">
    <table>
        <tr>
            <td colspan="2">Вход в приложение:</td>
        </tr>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="j_username" /></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="j_password"/ ></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Go" /></td>
        </tr>
    </table>
</form>
</body>
</html>