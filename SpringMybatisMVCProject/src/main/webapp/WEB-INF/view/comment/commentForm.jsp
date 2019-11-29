<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="commentInsert" name="frm" commandName="commentCommand">
	입력할 제목 : <form:input path="commentSubject"/><br>
	입력할 내용 : <form:textarea path="commentContent" cols="67" rows="15"/>
	<input type="submit" value="전송">
</form:form>
</body>
</html>