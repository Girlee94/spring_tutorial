<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기 페이지</h1>
	<form action="${pageContext.request.contextPath }/freeboard/writeContentProcess.do" method="post">
		제목 : <input type="text" name="freeboard_title"><br>
		작성자 : ${ sessionUser.member_nick }<br>
		내용 : <br>
		<textarea name="freeboard_content" rows="10" cols="40"></textarea>
		<br>
		<input type="submit" value="작성">
	</form>
</body>
</html>