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
<form:form action="commentInsert" name = "frm" 
		commandName="commentCommand">
	입력할 제목 : <form:input path="commentSubject" /><br />
	입력할 내용 : <form:textarea path="commentContent" 
					cols="67" rows="15"/><br />
	<input type="submit" value="전송">
</form:form>
</body>
</html>