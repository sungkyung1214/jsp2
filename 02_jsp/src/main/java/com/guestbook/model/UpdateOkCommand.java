package com.guestbook.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook.db.DAO;
import com.guestbook.db.VO;

public class UpdateOkCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 입력해서 받아온 값들 세팅 하기
		String idx = request.getParameter("idx");
		VO vo2= new VO();
		vo2.setIdx(idx);
		vo2.setName(request.getParameter("name"));
		vo2.setSubject(request.getParameter("subject"));
		vo2.setContent(request.getParameter("content"));
		vo2.setEmail(request.getParameter("email"));
		
		// 업데이트 
		int result= DAO.getUpdate(vo2);

		// 업데이트 성공 후 다시 onelist로 가기 때문에 idx로 하나의 정보를 다시 가져ㅘ야 한다.
		VO vo = DAO.getOneList(idx);
		request.setAttribute("vo", vo);
		return "guestbook/onelist.jsp";
	}
}
