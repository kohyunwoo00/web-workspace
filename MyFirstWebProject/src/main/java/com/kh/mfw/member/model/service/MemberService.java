package com.kh.mfw.member.model.service;

import com.kh.mfw.member.model.dao.MemberDAO;
import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberService {
	
	public MemberDTO login(MemberDTO member) {
		
		/*
		 * 로그인이라 함은 DB에가서 SELECT절에다가 사용자가 입력한 아이디값,비밀번호값을 조건절에
		 * 사용해서 조회를 하는 절차를 의미 
		 * -> ID가 틀리거나 PW가 틀려서 로그인 실패할 수 있는 가능성 O
		 * 
		 * member.getMemberId().length() > 10
		 * meber.getMemberPw().equals("")
		 * 
		 * 위 조건이 틀리면 DB에 갈 필요 x
		 * 서비스단에서 유효성검사하기
		 */
		
		MemberDTO loginMember = new MemberDAO().login(member);
		return loginMember;	
	}
	public int signUp(MemberDTO member) {
		int result = new MemberDAO().checkId(member.getMemberId());
		
		if(result > 0) {
			return result;
		}
		new MemberDAO().signUp(member);
		return result;
	}
}
