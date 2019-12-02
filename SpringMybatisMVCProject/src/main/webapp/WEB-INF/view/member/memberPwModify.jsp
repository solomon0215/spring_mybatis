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
<form:form action ="pwModifyPro" method="post" name="frm" 
		id="frm" commandName="changePwdCommand" >
	현재비밀번호 : <input type="password" name = "currentPassword" 
	             id ="pw" />
	             <form:errors path ="currentPassword"/><br />
	새 비밀번호 : <input type="password" name = "newPassword" 
	             id ="newPw" />
	             <form:errors path ="newPassword"/><br />
	새 비밀번호 확인 : <input type="password" name = "reNewPassword" 
	             id ="reNewPw" />
	             <form:errors path ="reNewPassword"/><br />
	<input type="submit" value = "비밀번호변경" id ="sbm"/>
</form:form>	 
</body>
</html>