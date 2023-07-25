package com.guestbook.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook.db.DAO;

public class DeleteOKCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String idx = request.getParameter("idx");
		int result = DAO.getDelete(idx);
		
		return "GuestController?cmd=list";
	}
}
