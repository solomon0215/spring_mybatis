<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../publicFile/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> <spring:message code = "member.register" /> </title>
</head>
<body>
	<h2>약관 내용</h2>
	<p><spring:message code = "term" /></p>
	<form action="regist" method="post">
		<label>
		<input type="checkbox" name="agree" value="true"> 
			<spring:message code = "term.agree" />
		</label>
	<input type="submit" value="<spring:message code = "next.btn" />" />
</form>
</body>
</html>







