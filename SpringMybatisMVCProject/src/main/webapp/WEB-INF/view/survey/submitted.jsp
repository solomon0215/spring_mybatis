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
<title>응답 내용</title>
</head>
<body>
<p>응답 내용 :</p>
 	<c:forEach var="response" items="${ansData.responses}" varStatus="status">
 		${status.count +1}번 문항 : ${response }<br>
 	</c:forEach>
 	<p>응답자 위치 : ${ansData.res.location}</p>
 	<p>응답자 나이 : ${ansData.res.age}</p>
</body>
</html>