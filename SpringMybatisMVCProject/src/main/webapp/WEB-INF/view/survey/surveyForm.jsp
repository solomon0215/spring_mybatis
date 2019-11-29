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
<title>설문조사</title>
</head>
<body>
<h2>설문조사</h2>
<form method="post">
	<c:forEach var="q" items="${questions}" varStatus="status">
	<p>
		${status.count}번 문제)&nbsp;${q.title}
		<c:if test="${q.choice}">
		 	<c:forEach var="option" items="${q.options}">
		 		<label><input type="radio" name="responses[${status.index}]" value="${opntion}">${opntion}</label>
		 	</c:forEach>
		</c:if>
		<c:if test="${!q.choise}">
			<label><input type="text" name="responses[${status.index}]"></label>
		</c:if>
	</p>
	</c:forEach>
	<p>
	응답자 위치 : <br> 
		<input type="text" name="res.location">
	</p>
	<p>
	응답자 나이 : <br> 
		<input type="number" name="res.age">
	</p>
	<input type="submit" value="submit">
</form>
</body>
</html>