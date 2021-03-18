<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 페이지</h1>
	<c:choose>
		<c:when test="${!empty sessionUser }">
			${ sessionUser.member_nick }님 하이! <a href="${pageContext.request.contextPath }/member/logoutProcess.do">로그아웃</a>
		</c:when>
		<c:otherwise>
			비회원입니더... <a href="${pageContext.request.contextPath }/member/loginPage.do">로그인</a>
		</c:otherwise>
	</c:choose>
	<hr>
	<table border="1">
		<tr><td>글번호</td><td>제목</td><td>작성자</td><td>조회수</td><td>작성일</td></tr>
		<c:forEach items="${freeboardList }" var="list">
			<tr>
				<td>${list.freeboardVO.freeboard_no }</td>
				<td><a href="${pageContext.request.contextPath }/freeboard/readContentPage.do?freeboard_no=${list.freeboardVO.freeboard_no }">${list.freeboardVO.freeboard_title }</a></td>
				<td>${list.memberVO.member_nick }</td>
				<td>${list.freeboardVO.freeboard_readcount}</td>
				<td>${list.freeboardVO.freeboard_writedate}</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:if test="${!empty sessionUser }">
		<a href="${pageContext.request.contextPath }/freeboard/writeContentPage.do">글쓰기</a>
	</c:if>
	
	
</body>
</html>