<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<script type="text/javascript">
$(function(){
	$("#bsel").change(function(){
		$.ajax({
			type:"POST",
			url : "cDomino",
			data : "a="+ $("#asel").val()+"&c=" + $("#bsel").val(),
			datatype : "html",
			success : function(data1){
				$("#cDTO").html(data1);
			}
		});
	});
});
</script>
		<h2>Second Domino</h2>
		<select id="bsel" name="bNum">
			<option value="">--------선택하세요--------</option>
			<c:forEach var="bDTO" items="${bDTOs}">
			<option value="${bDTO.c}">${bDTO.d}</option>
			</c:forEach>
		</select>