<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/main.jsp</title>
</head>
<body>
<h1>member/main.jsp</h1>
<%
// p510 ~ 537
// p512 EL (Expression Language,표현언어)
//       <%="하나의내용 출력" % >  => 좀더 편하게 출력하기 위해 제공 ${출력내용}
//       p516 연산자 empty  => null,0 이면 (비어있으면)
//                  /  div , %  mod , && and, || or, ! not
//                  == eq, != ne, < lt , > gt, <= le, >= ge 
//       p513 내장객체 sessionScope : Session영역 사용하는 내장객체
//                  requestScope : requestScope영역 사용하는 내장객체

// p519 JSTL(JSP Standard Tag Library) => if,for % 대신에  태그처럼 사용 
// p510 JSTL 프로그램 설치 http://tomcat.apache.org
// Apache Tomcat - Taglibs - Download
// Impl:taglibs-standard-impl-1.2.5.jar (pgp, sha512)
// Spec:taglibs-standard-spec-1.2.5.jar (pgp, sha512)
// EL:taglibs-standard-jstlel-1.2.5.jar (pgp, sha512)
// Compat:taglibs-standard-compat-1.2.5.jar (pgp, sha512)
// => 프로젝트 - src / main / webapp / WEB-INF / lib 4개 파일 넣기
// => core(if,for,..), fmt(날짜,숫자 포맷), xml, sql 종류
// => 설치된것 가져오기 
// %@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %
// => p519 core <c:set> 변수선언, <c:if>, <c:choose> <c:when> <c:otherwise>
//              <c:forEach> 반복, <c:forTokens> "사과;바나나;포도" ;기준으로 반복
//              <c:redirect> 이동, <c:url> 주소
// => p526 fmt
// %@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %
// <fmt:requestEncoding> 한글처리, <fmt:formatDate>날짜포맷,
// <fmt:formatNumber> 숫자포맷

String id = (String)session.getAttribute("id");
//세션값(로그인 정보)이 없으면(세션값이 null이면)=>login.jsp이동
// if(id == null){
// 	response.sendRedirect("login.me");
// }
%>
<c:if test="${ empty sessionScope.id}">
	<c:redirect url="/member/login" />
</c:if>
<%=id %> , ${sessionScope.id } 님 로그인 하셨습니다.
<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a><br>
<a href="${pageContext.request.contextPath}/member/info">회원 정보 조회</a><br>
<a href="${pageContext.request.contextPath}/member/update">회원 정보 수정</a><br>
<a href="${pageContext.request.contextPath}/member/delete">회원 정보 삭제</a><br>

<%
// // 로그인한사용자 null이 아닌경우
// if(id != null){
// // if 로그인한사용자   관리자가 "admin"  => 일치하면 회원 목록 보이기
// 	if(id.equals("admin")){
%>
<!-- 		<a href="list.me">회원 목록</a><br> -->
<%
// 	}
// }
%>
<c:if test="${ ! empty sessionScope.id }">
	<c:if test="${ sessionScope.id eq 'admin'}">
		<a href="${pageContext.request.contextPath}/member/list">회원 목록</a><br>
	</c:if>
</c:if>


<a href="write.bo">글쓰기</a><br>
<a href="list.bo">글목록</a><br>

</body>
</html>





