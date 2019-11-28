<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회</title>
</head>
<body>
	<form:form  commandName="listCommand">
	<p>
		<label>from: <form:input path="from" /></label>
		<form:errors path="from" />
		~
		<label>to:<form:input path="to" /></label>
		<form:errors path="to" />
		<input type="submit" value="조회">
	</p>
	</form:form>
	<c:if test="${! empty members}">
	<table>
		<tr>
			<th>아이디</th><th>이메일</th><th>이름</th><th>가입일</th>
		</tr>
	<c:forEach var="mem" items="${members}" >
		<tr>
			<td>
			<a href="<c:url value='/member/memberInfo/${mem.userId}'/>" >
			${mem.userId}
			</a>
			</td><td>${mem.userEmail}</td>
			<td>${mem.userName}</td>
			<td><fmt:formatDate value="${mem.userRegist}"
			   pattern="yyyy-MM-dd"/></td>
		</tr>
	</c:forEach>
		<tr align="center" height="20">
			<td colspan=3>
				<c:if test="${page <=1 }">
				[이전]&nbsp;
				</c:if>
				<c:if test="${page>1 }">
				<a href="memberList?page=${page-1}">[이전]</a>&nbsp;	
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
					<a href="memberList?page=${i}">[${i}]</a>&nbsp;
				</c:forEach>
				
				<c:if test="${page>=maxPage }">
					[다음]&nbsp;
				</c:if>
				<c:if test="${page<maxPage }">
				<a href="memberList?page=${page+1}">[다음]</a>&nbsp;
				</c:if>		
				
				
			</td>
		</tr>
	</table>
	</c:if>
</body>
</html>