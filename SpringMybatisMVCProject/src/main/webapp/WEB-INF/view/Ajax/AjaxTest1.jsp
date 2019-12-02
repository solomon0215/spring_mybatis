<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn1").click(function(){
			$("#frm").ajaxSubmit({
				type:"POST",
				url:"AjaxTest1",
				dataType:"html",
				success:function(result){
					$("#notice_content").html(result);
				}
			});
		});
		$("#btn2").click(function(){
			var options = {
					type:"POST",
					url:"AjaxTest1",
					dataType:"html",
					success:function(result){
						$("#notice_content").html(result)
					}
					};
			$("#frm").ajaxSubmit(options);
		});
		$("#btn3").click(function(){
			var options = {
					type:"POST",
					url:"AjaxTest2",
					dataType:"html",
					beforeSubmit: application_check,
					success:application_ok,
					error: function(){
						alert('에러가 나왔다 홀홀홀~');
						return;
					}
					};
			$("#frm").ajaxSubmit(options);
		});
	});
	
	function testDiv(n){
		$.ajax({
			type:"POST",
			url:"AjaxTest1",
			dataType:"html",
			data:"n=" +n, // AjaxTest1?n=1
			success:function(result){
				$("#notice_content").html(result);
			}
		});
	}
	function application_check(){
		if($("#n").val() == ""){
			alert("값을 입력하렴 홀홀홀~~");
			return false;
		}else {
			alert("Ajax가 실행되기전에 사용하는 함수다 홀홀홀~~")
		}
	}
	function application_ok(responseText, statusText, xhr, $form){//responseText -> 결과값,statusText-> 성공여부,xhr->xmlhttprequest ,$form->보낸 폼
		if(statusText="success"){ //성공여부
			$("#notice_content").html(responseText);
			$form.css('background','red');
		}
	}
	testDiv(1);
</script>
</head>
<body>
	AjaxTest 입니다.
	<div id="notice_content">
		
	</div>
	<button id ="btn" onclick="testDiv('1')">버튼</button>
	<form id="frm" action="AjaxTest1">
		<input type="text" id="n" value="1" name="n"/> 
	</form>
	<button id="btn1">버튼1</button>
	<button id="btn2">버튼2</button>
	<button id="btn3">버튼3</button>
</body>
</html>