<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title" /></title>
</head>
<body>
<!-- 로그인 되지 않았을 때 -->
<c:if test="${empty authInfo}">
<form:form id="frm" name="frm" action="login" method="post" 
	commandName="loginCommand" >
<table border =1>
<tr><td colspan=3>
		<spring:message code="autoLogin" />
		<form:checkbox path="autoLogin" />
	</td></tr>
<tr><td>아이디</td>
    <td><form:input id="id1" path="id1"  />
    	<form:errors path="id1" />
    </td>
	<td><form:checkbox  path="idStore" /> :
	<spring:message code="rememberId" />  </td>
</tr>
<tr><td>비밀번호</td>
	<td><form:password id="pw" path="pw" />
		<form:errors path="pw" />
	</td>
	<td><input type="submit" id="btn" value="로그인" /></td>
</tr>
<tr><td colspan=2>
		<a href="#">아이디 찾기</a>|<a href="#">비밀번호 찾기</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="register/agree">회원가입</a>
    </td>
</tr>
</table>
</form:form>
</c:if>
<!-- 로그인 되었을 때 -->
<c:if test="${!empty authInfo}">
${authInfo.name }님 환영합니다.<br />
<a href = "member/memberDetail">내 정보</a>
<a href = "logout" >로그아웃</a>
<a href = "member/list">회원리스트</a>
<a href = "comment/commentList">댓글 게시판</a>
<a href = "board/answerBoardList">답변형 자료실</a>
<a href = "goodsList.gd">상품목록</a>
<a href = "memberAllMail">단체 메일보내기</a>
<a href = "survey" >설문지</a>
<a href = "ajaxTest">AjaxTest</a>
<a href = "AjaxForm">AjaxTest1</a>
<a href = "domino">도미노</a>
</c:if>
</body>
</html>