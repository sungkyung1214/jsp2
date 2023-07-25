package com.jsp.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex10_2_Model implements Command{
@Override
public String exec(HttpServletRequest request, HttpServletResponse response) {

	// 얘는 할 게 없음
	// 그냥 장바구니만 볼려고 호출하는거지 
	// 모델1번에서 session에다가 추가될때마다 알아서 넣어주기 때문에
	return "view/ex10_session_result.jsp";
}
}
