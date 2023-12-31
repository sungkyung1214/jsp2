package com.guestbook2.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook2.db.DAO;
import com.guestbook2.db.VO;

public class ListCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		List<VO> list = DAO.getList();
		
		request.setAttribute("list", list);
		
		return "guestbook2/list.jsp";
	}

}
