<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jQuery, Ajax and Servlet/JSP integration example</title>

    <script src="http://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script src="js/app-ajax.js" type="text/javascript"></script>
</head>
<body>

<form>
    <table>
        <tr>
            <td><label><b>ФИО</b></label></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>Фамилия: </td><td>    <input type="text" id="lastName"/></td>
            <td>Имя: </td><td>    <input type="text" id="fistName"/></td>
            <td>Отчество:</td><td>         <input type="text" id="middleName"/></td>
        </tr>
        <tr>
            <td>    <label><b>Город</b></label></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>Название:</td> <td>     <input type="text" id="cityName"/></td>
            <td></td> <td></td>
            <td></td>  <td></td>
        </tr>
        <tr>
            <td>    <label><b>Авто</b></label></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td> Марка:</td>  <td>    <input type="text" id="autoMark"/></td>
            <td></td> <td></td>
            <td></td>  <td></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>  <td align="right"><button type="button" id="submitButton">Найти</button></td>
        </tr>
    </table>

</form>
<br>
<br>

<strong>Ajax Response</strong>:
<div id="ajaxGetUserServletResponse"></div>
</body>
</html>