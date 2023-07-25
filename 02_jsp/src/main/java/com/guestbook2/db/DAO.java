package com.guestbook2.db;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

// DB처리하는 메서드들을 포함하고 있는 클래스

public class DAO {
	// 실제 사용하는 클래스 = SqlSession이다.
	private static SqlSession ss;

	// 싱글턴 패턴 (동기화처리) : 프로그램이 종료될 때 까지 한번 만들어진 객체를 재사용하는것.
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = DBService.getFactory().openSession();
		}
		return ss;
	}

	public static List<VO> getList() {
		List<VO> list = new ArrayList<>();
		list = getSession().selectList("guestbook2.getList");

		return list;
	}

	public static int getInsert(VO vo) {
		int result = getSession().insert("guestbook2.insert", vo);
		ss.commit();
		return result;
	}

	public static VO getOnelist(String idx) {
		VO vo = getSession().selectOne("guestbook2.getOnelist",idx);
		return vo;
	}

	public static int getUpdate(VO vo) {
		int result = getSession().update("guestbook2.update",vo);
		ss.commit();
		return result;
	}

	public static int getDelete(String idx) {
		int result = getSession().delete("guestbook2.delete",idx);
		ss.commit();
		return result;
	}

}
