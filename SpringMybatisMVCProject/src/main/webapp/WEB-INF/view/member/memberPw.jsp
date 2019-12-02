<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../publicFile/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action = "../edit/changePassword" Method="POST" 
		commandName="changePwdCommand">
		<spring:message code="password" /> : 
		<form:password path = "currentPassword" />
		<form:errors path="currentPassword" />
		<input type="submit" value="확인" />
	</form:form>
</body>
</html>