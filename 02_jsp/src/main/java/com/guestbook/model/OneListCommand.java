package com.guestbook.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook.db.DAO;
import com.guestbook.db.VO;

public class OneListCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//일처리 하고 저장
		
		//일처리 = (DB)
		//일처리 할려고 봤더니 파라미터가 한개 더 있다
		//한개면 그냥 파라미터이름으로, 두개 이상이면 vo 로 가져온다
		String idx= request.getParameter("idx");
		VO vo = DAO.getOneList(idx);
		
		// 저장
		request.setAttribute("vo", vo);
		
		return "guestbook/onelist.jsp";
	}

}
