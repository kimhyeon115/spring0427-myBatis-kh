<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<h3>총 게시글 수 : ${total}</h3>
	<hr>
	<c:forEach items="${list}" var="dto">
		<h2>글번호 : ${dto.mid}</h2>
		<h2>글쓴이 : ${dto.mwriter}</h2>
		<h2>글내용 : ${dto.mcontent}</h2>
		<h2>글삭제 : <input type="button" value="삭제" onclick="script:window.location.href='delete?mid=${dto.mid}'"></h2>
		<hr>
	</c:forEach>
</body>
</html>