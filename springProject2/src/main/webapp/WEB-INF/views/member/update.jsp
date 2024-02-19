<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/update.jsp</title>
</head>
<body>
<h1>member/update.jsp</h1>
<h1>나의 정보 수정 화면</h1>
<%
// //main.jsp에서 update.jsp로 이동할때 아무값도 없이 이동
// //연결정보를 저장하는 session내장객체 안에 로그인표시("id","kim") 저장
// //session에서 로그인 표시값 가져오기 => String id 변수 저장
// String id = (String)session.getAttribute("id");

// //자바파일 MemberDAO 객체생성 => 기억장소 할당
// MemberDAO memberDAO = new MemberDAO();
// System.out.println("MemberDAO의 기억장소 주소 : " + memberDAO);
// //MemberDTO memberDTO = MemberDAO의 기억장소주소.getMember(id) 메서드 호출
// MemberDTO memberDTO = memberDAO.getMember(id);
// // id 일치하면 => memberDTO에 id,pw,name,date 저장해서 주소 리턴(null 아님 리턴)
// // id 틀리면  => memberDTO에 비어있는 값                null 리턴
// System.out.println("리턴 받은 MemberDTO의 바구니 기억장소 주소 : " + memberDTO);

// MemberDTO memberDTO = (MemberDTO)request.getAttribute("memberDTO");

// if(memberDTO != null){
	%>
<!-- 	<form action="updatePro.me" method="post"> -->
<%-- 		아이디 : <input type="text" name="id" value="<%=memberDTO.getId()%>" readonly><br> --%>
<!-- 		비밀번호 : <input type="pwword" name="pw"><br> -->
<%-- 		이름 : <input type="text" name="name" value="<%=memberDTO.getName()%>"><br> --%>
<!-- 		<input type="submit" value="회원정보수정"> -->
<!-- 	</form> -->
	<%
// }else{
	%>
<!-- 	아이디 없음 -->
	<%
// }
%>

<%-- <c:set var="memberDTO" value="${requestScope.memberDTO }"/> --%>

<c:if test="${! empty memberDTO}">
	<form action="${pageContext.request.contextPath}/member/updatePro" method="post">
		아이디 : <input type="text" name="id" value="${memberDTO.id}" readonly><br>
		비밀번호 : <input type="pwword" name="pw"><br>
		이름 : <input type="text" name="name" value="${memberDTO.name}"><br>
		<input type="submit" value="회원정보수정">
	</form>
</c:if>

<c:if test="${empty memberDTO}">
	아이디 없음
</c:if>
	
	
	
</body>
</html>

