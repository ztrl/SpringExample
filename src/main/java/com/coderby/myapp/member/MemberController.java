package com.coderby.myapp.member;

public class MemberController {
	IMemberService memberService;
	
	public void setMemberSerivce(IMemberService memberSerivce) {
		this.memberService = memberSerivce;
	}
	
	public void printInfo() {
		MemberVO vo = memberService.getMemberInfo();
		System.out.println(vo);
	}
}
