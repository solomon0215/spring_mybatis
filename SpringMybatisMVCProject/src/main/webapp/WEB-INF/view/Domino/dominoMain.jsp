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
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">
	$(function(){
		$("#asel").change(function() {
			$.ajax({
				type:"POST",
				url : "bDomino",
				data : "a=" + $("#asel").val(),
				datatype : "html",
				success : function(data1){
					$("#bDTO").html(data1);
					$("#cDTO").html("");
				}
			});
		});
	});
</script>
</head>
<body>
	<span>
		<h2>First Domino</h2>
		<select id="asel" name="aNum">
			<option value="">--------선택하세요--------</option>
			<c:forEach var="aDTO" items="${aDTOs}">
			<option value="${aDTO.a}">${aDTO.b}</option>
			</c:forEach>
		</select>
	</span>
	<span id="bDTO">
		
	</span>
	<span id="cDTO">
		
	</span>
</body>
</html>