<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page session="true"%>

Пользователь '<%=request.getRemoteUser()%>' совершил выход.

<% session.invalidate(); %>

<br/><br/>
<a href="/">Нажмите здесь чтоб вернутся</a>