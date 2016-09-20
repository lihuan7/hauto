<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String username = request.getRemoteUser();
    String password = null;
    String message = "Username is : " + username + "<br/> Password is :" + password;
    String rememberMe = request.getParameter("rememberMe");
    if (rememberMe != null) {
        Cookie usernameCookie = new Cookie("username-cookie", username);
        Cookie passwordCookie = new Cookie("password-cookie", password);
        usernameCookie.setMaxAge(24 * 60 * 60);
        passwordCookie.setMaxAge(24 * 60 * 60);
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>hauto</title>
    <script src="http://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script src="js/json2html.js"></script>
    <script src="js/jquery.json2html.js"></script>
    <script src="js/app-ajax.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/style.css">
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <style type="text/css">
        body {
            font-size: 14px;
        }

        label {
            float: left;
            padding-right: 10px;
        }

        .field {
            clear: both;
            text-align: right;
            line-height: 25px;
        }

        .main {
            float: left;
        }

        /* DivTable.com */
        .divTable {
            display: table;
        }

        .divTableRow {
            display: table-row;
        }

        .divTableHeading {
            background-color: #EEE;
            display: table-header-group;
        }

        .divTableCell, .divTableHead {
            display: table-cell;
            padding: 3px 10px;
        }

        .divTableCellBorder, .divTableHeadBorder {
            border: 1px solid #999999;
            display: table-cell;
            padding: 3px 10px;
        }

        .wborder {
            border: 1px solid #999999;
            padding: 3px 10px;
        }

        .divTableHeading {
            background-color: #EEE;
            display: table-header-group;
            font-weight: bold;
        }

        .divTableFoot {
            background-color: #EEE;
            display: table-footer-group;
            font-weight: bold;
        }

        .divTableBody {
            display: table-row-group;
        }

        .resultTable {
            border: 1px solid #C0C0C0;
            border-collapse: collapse;
            padding: 5px;
        }

        .resultTable th {
            border: 1px solid #C0C0C0;
            padding: 5px;
            background: #F0F0F0;
        }

        .resultTable td {
            border: 1px solid #C0C0C0;
            padding: 5px;
        }

        .tftable {font-size:12px;color:#333333;width:100%;border-width: 1px;border-color: #729ea5;border-collapse: collapse;}
        .tftable th {font-size:12px;background-color:#acc8cc;border-width: 1px;padding: 8px;border-style: solid;border-color: #729ea5;text-align:left;}
        .tftable tr {background-color:#ffffff;}
        .tftable td {font-size:12px;border-width: 1px;padding: 8px;border-style: solid;border-color: #729ea5;}
        .tftable tr:hover {background-color:#ffff99;}
    </style>
</head>
<body>
<div id="content" class="login">
    <div>Пользователь: <%=request.getRemoteUser()%><p><a href="logout.jsp">Нажмите здесь, чтобы выйти</a></p></div>
    <br/>
    <br/>
    <br/>
    <form name="frm">
        <div class="divTable">
            <div class="divTableBody">
                <legend>ФИО</legend>
                <div class="divTableRow" title="ФИО">
                    <div class="divTableCell"><label> Фамилия:</label>
                        <p><input type="text" id="lastName"/></p></div>
                    <div class="divTableCell"><label> Имя:</label>
                        <p><input type="text" id="firstName"/></p></div>
                    <div class="divTableCell"><label> Отчество:</label>
                        <p><input type="text" id="middleName"/></p></div>
                </div>
                <legend>Город</legend>
                <div class="divTableRow">
                    <div class="divTableCell"><label> Название:</label>
                        <p><input type="text" id="cityName"/></p></div>
                    <div class="divTableCell">&nbsp;</div>
                    <div class="divTableCell">&nbsp;</div>
                </div>
                <legend>Автомобиль</legend>
                <div class="divTableRow">
                    <div class="divTableCell"><label> Марка:</label>
                        <p><input type="text" id="autoMark"/></p></div>
                    <div class="divTableCell"><label> Модель:</label>
                        <p><input type="text" id="autoModel"/></p></div>
                    <div class="divTableCell">&nbsp;</div>
                </div>
                <div class="divTableRow">
                    <div class="divTableCell">&nbsp;</div>
                    <div class="divTableCell">&nbsp;</div>
                    <div class="divTableCell">
                        <p class="submit">
                            <button type="button" id="submitButton">Поиск</button>
                        </p>
                    </div>
                </div>
            </div>
        </div>

    </form>
    <br/>
    <br/>
    <br/>
    <div id="ajaxFindHumanServletResponse">
        <table id="placar" class="tftable">
            <thead>
            <tr>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
                <th>Город</th>
                <th>Авто</th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>
</div>
</body>
</html>