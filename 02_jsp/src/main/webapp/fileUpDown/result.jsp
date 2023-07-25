<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과보기</h2>
	<h3>
		<li>올린사람 : ${name }</li>
		<li>파일 원본 이름 :${f_name }</li>
		<li>파일 저장 이름 :${f_name2 }</li>
		<li>파일 타입 : ${contenttype}</li>
		<li>파일 크기 : ${f_size }Byte</li>
		<li>마지막 수정날짜 :${f_last}</li>
		<li>마지막 수정날짜 :${f_last2}</li>
		<li><img src ="upload/${f_name2 }"></li>
		<li>다운로드: <a href="down.jsp?path=upload&f_name=${f_name2} }">${f_name2 }</a></li>
	
	</h3>
</body>	
</html>