<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<body>
<%
    Cookie[] cookies = request.getCookies();
    String username="";
    String password = "";
    if(cookies!=null)
    {
        for(int i=0;i<cookies.length;i++){
            Cookie cookie = cookies[i];
            if(cookie.getName().equals("username-cookie"))
            {
                username= cookie.getValue();
            }
            else if(cookie.getName().equals("password-cookie"))
            {
                password= cookie.getValue();
            }
        }
    }
%>
<form method="GET" action="security_check">
    <table>
        <tr>
            <td colspan="2">Вход в приложение:</td>
        </tr>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="j_username" value ="<%=username%>"/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="j_password" value="<%=password%>"/></td>
        </tr>
        <tr>
            <td>
                Запомнить меня<input name="rememberMe" type="checkbox" value="rememberMe"/>
            </td>
            <td colspan="2"><input type="submit" value="Войти"/></td>
        </tr>
    </table>
</form>
</body>
</html>