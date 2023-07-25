package com.guestbook.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

// DB 처리하는 메서드들을 가지고 있는 클래스
public class DAO {
	// 실제 사용하는 클래스 : SqlSession
	private static SqlSession ss;

	// 싱글턴 패턴(동기화처리) : 프로그램이 종료될 때까지 한번 만들어진 객체를 재 사용한다.
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = DBService.getFactory().openSession();
		}
		return ss;
	}

	
	// DB처리하는 메서드들
	// 전체 리스트 
	// 이름 : getlist => 내맘대로
	public static List<VO> getList(){ //파라미터 값 없음. 매퍼에서도 없으니까
		List<VO> list = getSession().selectList("guestbook.list"); //mapper의 id로 돌려준다
		//get~ 어쩌구는 메퍼 가는거
		return list; //=> 디비 갔다가 온 결과 ,그 결과를 가지고 자기를 호출 한 곳으로 간다. 호출한 곳은 모델(일시킬려고함)
		
	}
	
	// 정보DB에 저장할 때 (insert, update,delete는 결과가int
	public static int getInsert(VO vo) {
		int result = getSession().insert("guestbook.insert", vo); // 괄호안에 2번쨰vo 는 위 파라미터 vo 를 받아온이
										//""따옴표 안에 있는 게스트.인서트 는 내 맘대로 이름짓기
		ss.commit();//inser 업데이트 딜리트는 커밋을 해야한다
		return result;
	}
	
	
	// 프라이머리 키를 이용해서 하나의 상세정보 가져오기 
	public static VO getOneList(String idx) {
		VO vo = getSession().selectOne("guestbook.onelist", idx); // 앞에는 뭐야 멤퍼이름과 아이디
		return vo;
		
	}
	
	//업데이트( insert, update, delete의 결과는 int)
	public static int getUpdate(VO vo) {  //vo 이름은 내 맘대로 정할 수 있다.
		int result = getSession().update("guestbook.update", vo);
		// insert,update,delete 반드시 commit
		ss.commit();
		return result;	
	}
	
	public static int getDelete(String idx) {
		int result =getSession().delete("guestbook.delete", idx);
		ss.commit();
		return result;	
	}
}

//dao는 mapper랑 연결된 아이
// dao는 mapper를 호출한다.


//dao는 무조건 mapper 로 간다아아아아!!!!!
// dao 호출하는 애는 메인
// dao는 mapper 를 실행시키고 갔다가 온 애
