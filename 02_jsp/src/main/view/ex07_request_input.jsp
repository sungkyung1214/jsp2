<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 

서버한테 요구할때, 인자값을 필요로할 수도 있고 아닐 수도 있다
지금 상황은 id랑 pw 요구하는것 

-->
	<form action="<%=request.getContextPath()%>/Mycontroller01" method="post">
	<p>ID :<input type="text" name ="id" required></p>
	<p>pw :<input type="password" name ="pw" required></p>
	<input type="submit" value="로그인">
	</form>
</body>
</html>

