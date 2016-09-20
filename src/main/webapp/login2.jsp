<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  <link rel="stylesheet" href="css/style.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
  <section class="container">
    <div class="login">
      <h1>Вход в приложение</h1>
      <form method="GET" action="security_check">
        <p><input type="text" name="j_username" value ="<%=username%>" placeholder="Логин"></p>
        <p><input type="password" name="j_password" value="<%=password%>" placeholder="Пароль"></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="rememberMe" id="rememberMe">
            Запомнить меня на этом компьютере
          </label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="Вход"></p>
      </form>
    </div>
  </section>
</body>
</html>