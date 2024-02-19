<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/info.jsp</title>
</head>
<body>
<h1>member/info.jsp</h1>
<h1>나의 정보 조회</h1>
<%
// // main.jsp에서 info.jsp로 이동할때 아무값도 없이 이동
// // 연결정보를 저장하는 session내장객체 안에 로그인표시("id","kim") 저장
// // session에서 로그인 표시값 가져오기 => String id 변수 저장
// String id = (String)session.getAttribute("id");

// //자바파일 MemberDAO 객체생성 => 기억장소 할당
// MemberDAO memberDAO = new MemberDAO();
// System.out.println("MemberDAO의 기억장소 주소 : " + memberDAO);
// // MemberDAO에 리턴할형 MemberDTO  getMember(String id) 메서드 정의 
// // MemberDTO memberDTO = MemberDAO의 기억장소주소.getMember(id) 메서드 호출
// MemberDTO memberDTO = memberDAO.getMember(id);
// // id 일치하면 => memberDTO에 id,pass,name,date 저장해서 주소 리턴(null 아님 리턴)
// // id 틀리면  => memberDTO에 비어있는 값                null 리턴
// System.out.println("리턴 받은 MemberDTO의 바구니 기억장소 주소 : " + memberDTO);

// MemberDTO memberDTO = (MemberDTO)request.getAttribute("memberDTO");

// if(memberDTO != null){
	// 아이디 있음
	%>
<%-- 	아이디 : <%=memberDTO.getId() %><br> --%>
<%-- 	비밀번호 : <%=memberDTO.getPass() %><br> --%>
<%-- 	이름 : <%=memberDTO.getName() %><br> --%>
<%-- 	가입날짜 : <%=memberDTO.getDate() %><br> --%>
	<%
// }else{
	%>
<!-- 	아이디 없음 -->
	<%
// }
%>

<%-- <c:set var="memberDTO" value="${requestScope.memberDTO }"/> --%>

<c:choose>
	<c:when test="${ ! empty memberDTO }">
		아이디 : ${memberDTO.id}<br>
		비밀번호 : ${memberDTO.pw}<br>
		이름 : ${memberDTO.name}<br>
		가입날짜 : ${memberDTO.date}<br>
	</c:when>
	<c:otherwise>
		아이디 없음
	</c:otherwise>
</c:choose>


<a href="${pageContext.request.contextPath}/member/main">main 이동</a>
</body>
</html>


