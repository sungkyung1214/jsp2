<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
 스크립트요소 : HTML안에서 실제 자바 코드를 사용할 수 있도록 만드는 요소
	 	1) 선언부	(<%! 내용 %>) 		: 변수선언이나 메소드 선언할 때 사용 
	 	2) 스크립트릿(<% 자바코드 %>) 	: 자바코드를 코딩할 때 사용
	 	3) 표현식	(<%=  %>)			: 변수값이나 메서드의 결과(return 값) 등 저장되어이 있는 결과값 출력
	 	
	 	** out객체 : out.print(변수)
	 	 ** 현재는 표현식  대신 표현언어 (EL과 JSTL를 사용한다.)
	 	 
	 	 **주의 사항 : 선언부, 스크립트릿, 표현식을 겹쳐서 (또는 포함해서 사용할 수 없다.)
 --%>
	<h2>0-10까지 자바의 for문을 사용해서 출력하자</h2>
	<h3>
		<%
		for (int i = 0; i < 11; i++) {
		%>
		<%=i%>
		<%
		}
		%>
	</h3>
	<hr>
	<h2>0-10까지 자바의 for문을 사용해서 출력하자</h2>
	<h3>
		<%
		for (int i = 0; i < 11; i++) {
			// jsp에 화면에 출력하는 내장 객체 out 있다.
			out.println(i);
		}
		%>



		<h2>0-10까지 합을 자바의 for문을 사용해서 출력하자</h2>
		<%
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			sum = sum + i;
		}
		out.println("<h2>첫번째방법:" + sum + "</h3>");
		%>
		<hr>

		<h2>0-10까지 합을 자바의 for문을 사용해서 출력하자</h2>
		<%-- 스크립트에서도 변수 선언할 수 있다. --%>
		<%
		int sum2 = 0;
		for (int i = 0; i < 11; i++) {
			sum2 = sum2 + i;
		}
		%>
		<h3>
			두번째 방법 :
			<%=sum2%></h3>
		<!-- 나중에는 사용할 수 있다. -->
		<h3>세번째 방법 : ${sum2}</h3>
		<hr>

		<h2>0-10까지 합을 자바의 for문을 사용해서 출력하자</h2>
		<%-- 선언부에서는 변수선언과 메서드 선언을 할 수 있다. --%>
		<%!int sum3 = 0;%>
		<%for(int i = 0; i<11; i++){
		 sum3 = sum3 + i; 
		 }
		out.println("<h3>네번째방법:" + sum + "</h3>");
		%>
		<h3>다섯번째 방법 : <%= sum3 %></h3>
		<!-- 나중에는 사용할 수 있다 -->
		<h3>여섯번째 방법 : ${sum3} </h3>
		<hr>
		<h2>변수와 메서드를 만들어서 사용하기(선언부 사용하기)</h2>
		<%!
			public int add(int s1, int s2){
			return s1 + s2;
			}
		
			int result = 0 ;
			public void sub(int s1, int s2){
			result = s1 -s2;
			}
		%>
		<h3>7+5= <%= add(7,5) %> </h3>
		<%sub(7,5); %>
		<h3>7-5= <%= result %></h3>
		<h3>7-5= <% out.println(result);%></h3>
		
		<!-- 나중에는 사용할 수 있다 -->
		<h3>7-5= ${result}</h3>
		
		
		<hr>
		<h2>5단 출력하기</h2>
			<%
		for(int i = 1; i<10; i++){
			out.println("<h3>5*"+ i + "=" + (5*i) +"</h3>");
		}		
		%>
		
		<h2>오늘 날짜와 운세를 출력하자</h2>
		<%
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DATE);
		out.println("<h2>오늘날짜구하기</h2>");
		out.println("<h2>"+year+". "+month+". "+ day+"."+ "</h2>");
					
		%>
		
		<%
		int lucky = (int)(Math.random()*100)+1;
		out.println("<h2>운세구하기</h2>");
		out.println("<h2>오늘의 운세 : "+lucky+ "%입니다" +"</h2>");
		%>
	
</body>
</html>