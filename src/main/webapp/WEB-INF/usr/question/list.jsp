<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ����Ʈ</title>
</head>
<body>

	<h1>���� ����Ʈ</h1>
	
	<c:forEach var="question" items="${questions}">
		
		<div class="">
			
			<p>���� : ${question.title}</p>
			<p>���� : ${question.body}</p>
			<hr />
		
		</div>
		
	</c:forEach>
	
</body>
</html>