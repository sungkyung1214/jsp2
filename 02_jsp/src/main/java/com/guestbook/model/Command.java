package com.guestbook.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public String exec(HttpServletRequest request, HttpServletResponse response);
	//갈곳을 생각하기
	//list로 갈꺼니까 list command 만들어주기 고고!
	

}
