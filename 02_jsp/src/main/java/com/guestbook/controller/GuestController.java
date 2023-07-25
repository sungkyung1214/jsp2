package com.guestbook.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook.model.Command;
import com.guestbook.model.DeleteCommand;
import com.guestbook.model.DeleteOKCommand;
import com.guestbook.model.ListCommand;
import com.guestbook.model.OneListCommand;
import com.guestbook.model.UpdateCommand;
import com.guestbook.model.UpdateOkCommand;
import com.guestbook.model.WriteCommand;
import com.guestbook.model.WriteOkCommand;


@WebServlet("/GuestController")
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out= response.getWriter();
		//항상 쓰는 3줄 작성 후 model 만들러 가기
		
		String cmd= request.getParameter("cmd");// 파라미터가 있으니까 = cmd, 파라미터를 받아와야 한다
		//여기서 cmd=list
		Command comm =null; //Command를 인터페이스 받아서 또 여러가지 커맨드들이 생기니까 일단 제일 대가리를 전역변수로 뺴놓고
		
		if(cmd.equals("list")) {
			comm = new ListCommand();//객체 생성, 여기서 그 상속받은거에 이름에 따라 정해주기 
		}else if(cmd.equals("write")){
			comm = new WriteCommand();
		}else if(cmd.equals("write_ok")){
			comm = new WriteOkCommand();
		}else if(cmd.equals("onelist")){
			comm= new OneListCommand();
		}else if(cmd.equals("update")){
			comm= new UpdateCommand();
		}else if(cmd.equals("update_ok")){
				comm= new UpdateOkCommand();
		}else if(cmd.equals("delete")) {
			comm= new DeleteCommand();
		}else if(cmd.equals("deleteok")) {
				comm= new DeleteOKCommand();
		String path = comm.exec(request, response); //String 인 이유는 exec가 스트링이라서
		//path = GuestController?cmd=list 여기로 와서 다시 와서 제일 처음 if에 있는 list로 간다
		request.getRequestDispatcher(path).forward(request, response); //포워딩으로 보내주는 문법
	}
	}
}
