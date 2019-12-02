<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file = "../publicFile/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>설문조사</title>
</head>
<body>
<h2>설문조사</h2>
<form method="post">

<c:forEach var="q" items="${questions}" varStatus="status">
<p>
	${status.count }번 문제)  ${q.title }<br />
	<c:if test="${q.choice }">
		<c:forEach var="option" items="${q.options}">
			<label><input type="radio" 
			name="responses[${status.index}]" value="${option }" />${option }
		</c:forEach>
	</c:if>
	<c:if test="${! q.choice }">
		<input type="text" name="responses[${status.index}]">
	</c:if>
</p>
</c:forEach>

<p>
<label>응답자 위치:<br>
<input type="text" name="res.location">
</label>
</p>
<p>
<label>응답자 나이:<br>
<input type="text" name="res.age">
</label>
</p>
<input type="submit" value="전송">
</form>
</body>
</html>







