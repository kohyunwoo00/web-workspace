package com.kh.mfw.member.model.dao;

import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberDAO {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}
			
	}
	public void login(MemberDTO member) {
		List<MemberDTO> list = new ArrayList();
	}
}
