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
	<c:if test="${! empty comments}">
	<table>
		<tr>
			<th>번호</th><th>제목</th><th>등록일</th>
		</tr>
	<c:forEach var="comment" items="${ comments}" varStatus="status">
		<tr>
			<td>${status.count }</td>

			<td>
			<a href="<c:url value='commantCollection/${comment.commentNo}'/>" >
			${comment.commentSubject}</a></td>
			<td><fmt:formatDate value="${comment.regDate}"
			   pattern="yyyy-MM-dd"/></td>
		</tr>
	</c:forEach>
	</table>
	</c:if>
	<c:if test="${ empty comments}">
		입력돤 댓글이 없습니다. <br />
	</c:if>
	<a href = "commentReg" >댓글입력</a>
	<br />
	<br />
	<br />
	<form name="frm3"  method = "POST">
		<input type="text" name="commentNos">
		<input type="text" name="commentNos">
		<input type="text" name="commentNos">
		<input type="submit" value="전송">
	</form>
</body>
</html>