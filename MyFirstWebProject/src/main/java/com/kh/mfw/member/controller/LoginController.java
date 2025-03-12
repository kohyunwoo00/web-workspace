package com.kh.mfw.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mfw.member.model.dto.MemberDTO;
import com.kh.mfw.member.model.service.MemberService;

@WebServlet("/sign-in")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 절차
		// 1) GET / POST => 요청 전송방식이 POST라면 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청값이 있나? 없나? => 있다면 값을 뽑아서 가공
		// request.getparameter("input요소의 name속성값")
		// input요소 -> 무조건 input요소의 name속성 값을 적는것은 아님
		
		// memberId / memberPw
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		// System.out.printf("입력한 아이디값 : %s \n입력한 비밀번호값 : %s", userId, userPw);
		
		// 3) 값이 두 개 이상일 경우 어딘가에 예쁘게 담기
		MemberDTO member = new MemberDTO();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		new MemberService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
