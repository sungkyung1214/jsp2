<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>

	<jsp:forward page="/GuestController2">
		<jsp:param value="list" name="cmd" />
	</jsp:forward>

</body>
</html>