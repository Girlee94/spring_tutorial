package com.hj.pracproject.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hj.pracproject.member.service.MemberServiceImpl;
import com.hj.pracproject.vo.MemberVO;

@Controller
@RequestMapping("member/*")
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@RequestMapping("loginPage.do")
	public String loginPage() {
		
		return "member/loginPage";
	}
	
	@RequestMapping("joinMemberPage.do")
	public String joinMemberPage() {
		
		return "member/joinMemberPage";
	}
	
	@RequestMapping("joinMemberProcess.do")
	public String joinMemberProcess(MemberVO memberVO) {
		
		memberService.joinMember(memberVO);
		
		return "redirect:./loginPage.do";
	}
	
	@RequestMapping("loginProcess.do")
	public String loginProcess(MemberVO memberVO, HttpSession session) {
		
		MemberVO sessionMember = memberService.login(memberVO);
		if (sessionMember != null) {
			//로그인 성공 시
			session.setAttribute("sessionUser", sessionMember);
			
			return "redirect:../freeboard/mainPage.do";
		} else {
			//로그인 실패 시
			return "member/loginFail";
		}
	}
	
	@RequestMapping("logoutProcess.do")
	public String logoutProcess(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:../freeboard/mainPage.do";
	}
	
	
}
