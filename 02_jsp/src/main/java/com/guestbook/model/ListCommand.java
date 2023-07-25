package com.guestbook.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook.db.DAO;
import com.guestbook.db.VO;

public class ListCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//list command 만들었으면, 이제 여기에다가 일처리,저장,결과보여줄페이지를 작성하기
		
		// 일처리 => DB정보 가져오기 그럴라면 무조건 dao 가야함
		
		// 전체 목록 가져오기, 그래서 dao 가서 getlist 가기 
		List<VO> list = DAO.getList();
		// 여기저기 멀리 갔다왔찌
		
		// 저장(화면단에 보여주기위해)
		request.setAttribute("list", list);
		//자바는 일처리가 끝나면 저장하게 되어있다
		//저장을 하고 난 다음에 되돌아간다
		//되돌아갈때 결과를 보여줄 페이지로
		
		
		//결과 보여줄 페이지
		return"guestbook/list.jsp"; 
		
		// 다하고 나면 얘도 메서드, 자기를 호출한 곳으로 간다 거기가 어디? guestcontroller
		
	}

}
