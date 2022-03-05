<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>질문하기</title>
</head>
<body>

	<div class="">
		<h1>질문하기</h1>
	</div>
	
	<div class="question-form-container">
	
		<form action="/question/add" method="post">
		
			<div class="">
				<input type="text" name="title" placeholder="질문 제목을 입력해 주세요"/>
			</div>
			
			<div class="">
				<input type="text" name="body" placeholder="질문 내용을 입력해 주세요"/>
			</div>
			
			<div class="">
				<button>질문하기</button>
				<button type="button">취소</button>
			</div>
		
		
		</form>
	
	</div>
	
</body>
</html>