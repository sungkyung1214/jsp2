package com.guestbook2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook2.model.Command;
import com.guestbook2.model.DeleteCommand;
import com.guestbook2.model.DeleteOkCommand;
import com.guestbook2.model.ListCommand;
import com.guestbook2.model.OnelistCommand;
import com.guestbook2.model.UpdateCommand;
import com.guestbook2.model.UpdateOkCommand;
import com.guestbook2.model.WriteCommand;
import com.guestbook2.model.WriteOkCommanad;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class GuestController2
 */
@WebServlet("/GuestController2")
public class GuestController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String cmd = request.getParameter("cmd");
		Command comm = null;
		
		switch (cmd) {
		
		case "list":
			comm = new ListCommand();
			break;
		case "write":
			comm = new WriteCommand();
			break;
		case "write_ok":
			comm = new WriteOkCommanad();
			break;
		case "onelist":
			comm = new OnelistCommand();
			break;
		case "update":
			comm = new UpdateCommand();
			break;
		case "update_ok":
			comm = new UpdateOkCommand();
			break;
		case "delete":
			comm = new DeleteCommand();
			break;
		case "delete_ok":
			comm = new DeleteOkCommand();
			break;
		default:
			break;
			
		}
		String path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
