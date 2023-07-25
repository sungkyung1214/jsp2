<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 방 명 록 </title>
<style type="text/css">
	a { text-decoration: none;}
	table{width: 600px; border-collapse:collapse; text-align: center;}
	table,th,td{border: 1px solid black; padding: 3px}
	div{width: 600px; margin:auto; text-align: center;}
</style>
<script type="text/javascript">
	function save_go(f) {
		var k ="${vo.pwd}"; //자바스크립트에서도 EL을 사용할 수 있다.
		if(f.pwd.value == k ){
		//위에서 처럼 비번확인하고 같으면 넘겨줄꺼야
		f.action="/02_jsp/GuestController";
		f.submit();
			
		}else{
			alert('비밀번호가 틀립니다.');
			f.pwd.value="";
			f.pwd.focus(); //커서 깜빡깜빡
			return;//그냥 원래 페이지로 돌아간다
		}
	}
</script>
</head>
<body>
	<div>
		<h2>방명록 : 수정화면</h2>
		<hr />
		<p>[<a href="/02_jsp/GuestController?cmd=list">목록으로 이동</a>]</p>
		<form method="post"><!--  비밀번호니까 post로 보호 -->
			<table>
				<tr align="center">
					<td bgcolor="pink">작성자</td>
					<td><input type="text" name="name" size ="20" value="${vo.name }"/></td>
				</tr>
				<tr align="center">
					<td bgcolor="pink">제  목</td>
					<td><input type="text" name="subject" size ="20" value="${vo.subject }"/></td>
				</tr>
				<tr align="center">
					<td bgcolor="pink">email</td>
					<td><input type="text" name="email" size ="20" value="${vo.email}"/></td>
				</tr>
				<tr align="center">
					<td bgcolor="pink">비밀번호</td>
					<td><input type="password" name="pwd" size ="20" /></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<textarea rows="10" cols="60" name="content" value="${vo.content}"></textarea>
					</td>
				</tr>
				<tfoot>
					<tr align="center">
						<td colspan="2">
							<input type="hidden" value="update_ok" name="cmd">
							<input type="hidden" value="${vo.idx }" name="idx">
							
							<input type="button" value="저장" onclick="save_go(this.form)" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="취소" />
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>