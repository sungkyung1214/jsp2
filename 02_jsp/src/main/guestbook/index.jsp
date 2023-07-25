<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱스</title>
<script type="text/javascript">
	 /* function list_go() {
		location.href="/02_jsp/GuestController?cmd=list";
		//list대신 숫자로 해도 됨(자기맘대로),숫자로해도 파라미터값은 무조건 문자로 인식한다
		//여기서 list 뜻은 자기가 정하는건데,
		//현재index페이지에서 다음에 가야할 list페이지라서 내맘대로 list라고 정하기
	}  */
</script>
</head>
<body>
	 <!--  <button onclick="list_go()">리스트로 이동하기</button>  -->
	  
 <jsp:forward page="/GuestController">
		<jsp:param value="list" name="cmd"/>
		</jsp:forward>
		 	
	<%-- 	<jsp => 포워딩
		<c 	 => 리다이렉트
		jsp 포워딩으로 해줄때는 list랑 cmd 값을 따로 빼서 위에처럼 써줌
		그러면 바로 리스트로 쏘는거
	  --%>
</body>
</html>