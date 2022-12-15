package com.coderby.myapp.member;

public class MemberService implements IMemberService{

	@Override
	public MemberVO getMemberInfo() {
		MemberVO vo = new MemberVO();
		vo.setMemberID("SMY");
		vo.setName("신문영");
		vo.setAge(25);
		vo.setEmail("email@google.com");
		return vo;
	}

}
