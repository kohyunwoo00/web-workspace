package com.kh.mfw.member.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.mfw.common.Template.getSqlSession;

import com.kh.mfw.member.model.dao.MemberDAO;
import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberService {
	public MemberDTO login(MemberDTO member) {
		// JDBCUtill클래스로부터 static Mathod로 구현해놓은 
		// getConnection 메서드를 호출하여 Connection객체를 반환 받음
		SqlSession sqlSession = getSqlSession();
		
		// 유효성 검증 => 패스(원래 해야됨)
		MemberDTO loginMember = new MemberDAO().login(sqlSession, member); // 조회결과 x-> loginMember에 null값 반환
		sqlSession.close();
		return loginMember;
	}
	public int signUp(MemberDTO member) {
		// 3ck 유효성 검증 (Java)
		
		// 4차 데이터무결성을 위한 제약조건(DBMS)
	    // 아이디 중복 검사
		SqlSession sqlSession = getSqlSession();
		
		 if(new MemberDAO().checkId(sqlSession, member.getMemberId())) {
			 sqlSession.close();
			 return 0;
	     }
		 int result = new MemberDAO().signUp(sqlSession, member);
		 
		 sqlSession.commit();
		 sqlSession.close();
		 
	
		 return result;
	}
	
	
	
	
	
}
