<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 세션에 리스트
그 리스트 안에 과일들  
그래서 꺼낼때는 거꾸로-->
	<h2>장바구니 보기</h2>
	<h3>
	<%
		ArrayList<String> list = 
				(ArrayList<String>) session.getAttribute("list");
	
		if(list == null || list.size() <= 0 ){
			//장바구니가 없거나 or 장바구니 안에 아무것도 없거나
			out.println("장바구니가 텅!텅!");
			
		}else{
			for(String k : list){
				// 배열과 리스트는 개선된 포문 쓰는게 더 좋다
				out.println("<li>"+ k +"</li>");
			}
		}
	%>
	</h3>
</body>
</html>