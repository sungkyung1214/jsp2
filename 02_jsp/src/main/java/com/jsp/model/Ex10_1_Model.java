package com.jsp.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Ex10_1_Model implements Command{
@Override
public String exec(HttpServletRequest request, HttpServletResponse response) {
		//선택한 과일을 장바구니에 담자
		String fruits = request.getParameter("fruits");
		//이제 세션에 담아야한다 근데 지금 세션이없음. request에서는 session을 불러올 수 있음
		HttpSession ss = request.getSession();
		
		// 과일을 담아야 하지만 크기를 알 수 없다.
		ArrayList<String> list = 
				(ArrayList<String>)ss.getAttribute("list");
		
		// 맨처음에 해당 페이지로 오면 당연히 session에는 아무것도 없기 때문에(list 텅텅)
		if(list ==null) {
			//여기 널 값에 걸린애들은 처음 온애들 
			list = new  ArrayList<>(); // => 싱글턴패턴 : 프로젝트 만들 때,딱 한번만 객체 생성(new)해서
			//만들고 거기에 계속 담으면서 사용 하는것 
			ss.setAttribute("list", list);
		}
			// 리스트에 선택된 과일 추가
			list.add(fruits);
			
	
	return "view/ex10_session_cart.jsp";
}
}
