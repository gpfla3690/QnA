<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�����ϱ�</title>
</head>
<body>

	<div class="">
		<h1>�����ϱ�</h1>
	</div>
	
	<div class="question-form-container">
	
		<form action="/question/add" method="post">
		
			<div class="">
				<input type="text" name="title"/>
			</div>
			
			<div class="">
				<input type="text" name="body"/>
			</div>
			
			<div class="">
				<button>�����ϱ�</button>
				<button type="button">���</button>
			</div>
		
		
		</form>
	
	</div>
	
</body>
</html>