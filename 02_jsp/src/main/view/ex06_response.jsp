<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 : response</title>
<script type="text/javascript">
	function send_go1() {
		location.href ="ex02_script.jsp"
	}
	function send_go2() {
		location.href ="ex05_result.jsp?name=둘리&age=24&gender=남&hobby=운동&hobby=게임"
	}
</script>
</head>
<body>
<%--
	response(응답) : 응답에 대한 정보를 가지고 있음
	- 헤더 정보 입력
	- 쿠키정보 입력
	- 리다이렉트 : response.sendRedirect("이동할 주소")
	 ** 리다이렉트를 실행하면 request, response를 새로 만든다. ( 즉, 파라미터값을 가지고 있지 않다.)
 
 	================================================================================
 	웹 페이지 이동
 	1. a 태그를 통해서 웹 페이지 이동
 		<a href="이동할 주소"> 텍스트 </a>
 		// 파라미터값을 가지고 이동
 		<a href="이동할 주소?name=value&name=value"> 텍스트 </a>
 		
 	2. 자바스크립트를 통해서 웹 페이지 이동
 		- location.href = "이동할 주소";
 		- location.href = "이동할 주소?name=value&name=value";
 		
 		- history.go(숫자) : 웹 브라우저의 앞으로, 뒤로 와 같은 효과를 낸다.

	** 1과 2는 이벤트처리를 해야만 웹 페이지가 이동 된다.( 즉, 현재페이지가 보인다.)
	 		
	3. 리다이렉트 : response.sendRedirect("이동할 주소")
				 기존의 request, response는 사라진다.
				 새로운 request, response가 만들어진다.
				 파라미터 정보도 사라진다.
				 주소창에는 최종 주소가 보인다.
				 
	4. 포워드		: request.getRequestDispacher("이동할주소").forward( request, response);
				  기존의 request와 response 정보를 유지한다.
				  파라미터 정보가 사라지지 ㅏㄶ는다.
				  주소창에 최초 주소가 보인다.
				  
	** 3과 4는 이벤트처리 없이 자동으로 웹 페이지가 이동된다.(현재 페이지가 보이지 않는다.) 
 --%>
 <p><a href ="ex02_script.jsp">ex02_script(파라미터없음)</a></p>
 <p><a href ="ex05_result.jsp?name=둘리&age=24&gender=남&hobby=운동&hobby=게임">ex05.jsp(파라미터있음)</a></p>
 <hr>
 
 <button onclick="send_go1()">이동하기(파라미터없음)</button>
 <button onclick="send_go2()">이동하기(파라미터있음)</button>
 
 <%-- 리다이렉트 --%>
 <%--<% response.sendRedirect("ex02_script.jsp") ;--%>
 <%--<% response.sendRedirect("ex05_result.jsp?name=둘리&age=24&gender=남&hobby=운동&hobby=게임") ;--%>

<%-- 포워딩 --%>
 <%-- request.getRequestDispatcher("ex02_script.jsp").forward(request, response); --%>
 <%-- request.getRequestDispatcher("ex05_result.jsp?name=둘리&age=24&gender=남&hobby=운동&hobby=게임").forward(request, response); --%>

</body>
</html>