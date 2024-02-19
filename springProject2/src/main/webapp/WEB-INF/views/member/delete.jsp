<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/delete.jsp</title>
</head>
<body>
<h1>member/delete.jsp</h1>
<h1>나의 정보 삭제 화면</h1>
<%
//main.jsp에서 delete.jsp로 이동할때 아무값도 없이 이동
//연결정보를 저장하는 session내장객체 안에 로그인표시("id","kim") 저장
//session에서 로그인 표시값 가져오기 => String id 변수 저장
// String id = (String)session.getAttribute("id");
%>
<form action="${pageContext.request.contextPath}/member/deletePro" method="post">
아이디 : <input type="text" name="id" value="${sessionScope.id}" readonly><br>
비밀번호 : <input type="password" name="pw"><br>
<input type="submit" value="회원정보삭제">
</form>
</body>
</html>


