<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>질문 리스트</title>
</head>
<body>

	<h1>질문 리스트</h1>
	
	<c:forEach var="question" items="${questions}">
		
		<div class="">
			
			<p>제목 : ${question.title}</p>
			<p>내용 : ${question.body}</p>
			<hr />
		
		</div>
		
	</c:forEach>
	
</body>
</html>