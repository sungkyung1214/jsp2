package com.guestbook.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook.db.DAO;
import com.guestbook.db.VO;

public class UpdateCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 업데이트를 하기 위해서는 idx를 이용해서 DB정보를 가져오자
		String idx = request.getParameter("idx");
		// onelist할때 사용한 메서드
		VO vo = DAO.getOneList(idx);
		
		request.setAttribute("vo", vo);
		return "guestbook/update.jsp";
	}
}
