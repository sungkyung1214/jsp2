package com.guestbook.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 아무일 안 하고 그냥 저스트 페이지 이동
		// 그래서 갈 곳만 지정해주면 된다.
		
		
		
		
		
		return "guestbook/write.jsp";
	}

}
