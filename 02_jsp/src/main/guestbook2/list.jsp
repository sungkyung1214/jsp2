<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 600px;
	margin: auto;
	text-align: center;
}
table, th, td{
	border: 1px solid black;
	padding: 3px;
}
a{
	text-decoration: none;
}
th {
	background-color: fuchsia;
}

</style>
</head>
<body>
	<h3 style="text-align: center;">방명록</h3>
	<hr>
	<p style="text-align: center;">
		[ <a href="/02_jsp/GuestController2?cmd=write">방명록쓰기</a> ]
	</p>
	<div>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="4" >
								<h2 style="text-align: center;">작성된 방명록이 없습니다.</h2>
							</td>
						</tr>
					</c:when>
					<c:otherwise>
					<c:forEach items="${ list}" var="k" varStatus="vs">
						<tr>
							<td>${vs.count }</td>
							<td>${k.name }</td>
							<td> <a href="/02_jsp/GuestController2?cmd=onelist&idx=${k.idx}">${k.subject }</a> </td>
							<td>${k.regdate.substring(0,10) }</td>
						</tr>
					</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</body>
</html>