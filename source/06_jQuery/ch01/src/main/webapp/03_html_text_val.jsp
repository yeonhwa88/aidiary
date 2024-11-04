<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
		$(document).ready(function(){
			// p태그와 input태그에 내용을 넣기
			$('#msg').html('<b>중복된 아이디입니다</b>');
			//$('#msg').text('<b>사용가능한 아이디입니다</b>'); // text에는 태그가 그대로 나타남
			$('input[name="msg"]').val('Hello, jQuery'); // val == value
			// button 클릭시 : p태그안의 내용과 input 태그의 value를 가져와서 alert창에 출력
			$('button').click(function(){
				var pMsgTag = $('p#msg').html(); // <b>중복된 아이디입니다</b> 태그까지 전부 가져옴 
				var pMsgText = $('p#msg').text(); // 중복된 아이디입니다 텍스트만 가져옴
				var inputMsg = $('input[name="msg"]').val(); // 현재 value값
				alert(pMsgTag + '\n' + pMsgText + '\n' + inputMsg)
			});
		});
	</script>
</head>
<body>
	<p id="msg"></p>
	<p>정보 : <input type="text" name="msg"></p>
	<button>msg 내용 alert</button>
</body>
</html>