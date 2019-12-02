<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../publicFile/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register" /></title>
</head>
<body>
<p><spring:message code="register.done"  
arguments = "${memberCommand.userName },${memberCommand.userEmail }"/>
<p><a href="<c:url value='/main'/>">[<spring:message code="go.main" />]</a></p>
</body>
</html>