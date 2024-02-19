<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/insert.jsp</title>
</head>
<body>
<!-- 가상주소  http://localhost:8080/myweb/member/insert -->
<!-- 실제페이지 http://localhost:8080/myweb/member/insert.jsp -->

<!-- 현위치 =>  http://localhost:8080/myweb/member/member/insertPro -->
<!-- 절대위치 => http://localhost:8080/프로젝트명/member/insertPro -->
<h1>member/insert.jsp</h1>
<h1>회원가입</h1>
<form action="${pageContext.request.contextPath}/member/insertPro" method="post">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="pw"><br>
이름 : <input type="text" name="name"><br>
<input type="submit" value="회원가입">
</form>
</body>
</html>



