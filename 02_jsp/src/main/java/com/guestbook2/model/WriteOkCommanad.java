package com.guestbook2.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guestbook2.db.DAO;
import com.guestbook2.db.VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteOkCommanad implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 실제 저장위치
			String path = request.getServletContext().getRealPath("upload");
			
			// File input을 받을때는 항상 mr로 파라미터 받는다.
			MultipartRequest mr=
					new MultipartRequest(request, path, 100*1024*1024,"utf-8",new DefaultFileRenamePolicy());
			
			VO vo = new VO();
			vo.setName(mr.getParameter("name"));
			vo.setSubject(mr.getParameter("subject"));
			vo.setContent(mr.getParameter("content"));
			vo.setEmail(mr.getParameter("email"));
			vo.setPwd(mr.getParameter("pwd"));
			
			// 첨부파일이 있을 때와 없을 때를 구별해서 처리하자
			if(mr.getFile("f_name")!=null ) {
				vo.setF_name(mr.getFilesystemName("f_name"));
			}else {
				vo.setF_name("");
			}
			
			int result = DAO.getInsert(vo);
			if(result>0) {
				return "GuestController2?cmd=list";
			}else {
				// 오류처리페이지로 넘기기
				return "guestbook2/error.jsp";
			}
				
		} catch (Exception e) {
			return "guestbook2/error.jsp";
		}
	}

}
