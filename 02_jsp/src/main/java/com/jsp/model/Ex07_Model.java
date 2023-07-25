package com.jsp.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex07_Model implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 일처리
		// 파라미터 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		// 실제 로그인 DB 정보를 이용
		// 간단하게 ID와 PW가 같으면 로그인 성공, 아니면 로그인 실패
		// 저장
		if(id.equals(pw)) {
			//성공 저장
			request.setAttribute("logInChk", 1);
			
		}else {
			//실패 저장
			request.setAttribute("logInChk", 0);
		}
		
		
		
		
		// 결과 보여줄 페이지
		
			
		return "view/ex07_request_result.jsp";
	}
}
//