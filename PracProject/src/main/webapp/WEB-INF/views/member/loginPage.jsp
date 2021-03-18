<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕! 이건 나의 로그인  페이지 !</h1>
	<hr>
	<form action="${pageContext.request.contextPath }/member/loginProcess.do" method="post">
		ID : <input type="text" name="member_id"><br>
		PW : <input type="password" name="member_pw"><br>
		<input type="submit" value="로그인">
	 </form>
	 <br>
	 <a href="./joinMemberPage.do">회원가입</a>
</body>
</html>
