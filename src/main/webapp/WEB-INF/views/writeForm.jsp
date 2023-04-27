<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄 게시판 글쓰기</title>
</head>
<body>
	<h1>한줄 게시판 글쓰기</h1>
	<hr>
	<form action="write">
		이  름 : <input type="text" name="mwriter" size="60"><br><br>
		한줄내용 : <input type="text" name="mcontent" size="100"><br><br>
		<input type="submit" value="한줄입력">	
	</form>
</body>
</html>