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
	<c:if test = "${ commentReply != null}" >
	게시글번호 : ${commentReply.commentDTO.commentNo }<br />
	아이디 : ${commentReply.commentDTO.userId }<br />
	내용 : ${commentReply.commentDTO.commentSubject }<br />
	내용 : ${commentReply.commentDTO.commentContent }<br />
	등록일 : ${commentReply.commentDTO.regDate }<br />
	ip주소 : ${commentReply.commentDTO.ipAddr }<br />
	<form action = "../replyPro" method="POST">
	댓글 달기 : <textarea name = "commentContent" cols= "50", rows="5"></textarea>
			  <input type="hidden" name = "commentNo" 
			  			value= "${commentReply.commentDTO.commentNo }" />
			  <input type = "submit" value="댓글 등록" />
	</form>
**** 댓글 *********
	<c:forEach var="reply" items="${commentReply.replys}" >
	<p>
	게시글번호 : ${reply.replyNo }<br />
	아이디 : ${reply.userId }<br />
	내용 : ${reply.commentContent }<br />
	등록일 : ${reply.regDate }<br />
	ip주소 : ${reply.ipAddr }<br />
	</p>
	</c:forEach>
	</c:if>
	<c:if test = "${ comment != null}" >
	게시글번호 : ${comment.commentNo }<br />
	아이디 : ${comment.userId }<br />
	내용 : ${comment.commentContent }<br />
	등록일 : ${comment.regDate }<br />
	ip주소 : ${comment.ipAddr }<br />
	<input type="button" value="삭제"/>
	<form action = "../replyPro" method="POST">
	댓글 달기 : <textarea name = "commentContent" cols= "50", rows="5"></textarea>
			  <input type="hidden" name = "commentNo" 
			  			value= "${comment.commentNo }" />
			  <input type = "submit" value="댓글 등록" />
	</form>
	</c:if>
</body>
</html>