package com.hj.pracproject.freeboard.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hj.pracproject.freeboard.service.FreeboardServiceImpl;
import com.hj.pracproject.vo.FreeboardVO;
import com.hj.pracproject.vo.MemberVO;

@Controller
@RequestMapping("freeboard/*")
public class FreeboardController {
	
	@Autowired
	private FreeboardServiceImpl freeboardService;
	
	@RequestMapping("mainPage.do")
	public String mainPage(Model model) {
		
		//글 리스트 출력
		ArrayList<HashMap<String, Object>> list = freeboardService.getFreeboardList();
		
		model.addAttribute("freeboardList", list);
		
		return "freeboard/mainPage";
	}
	
	@RequestMapping("writeContentPage.do")
	public String writeContentPage() {
		
		
		return "freeboard/writeContentPage";
	}

	@RequestMapping("writeContentProcess.do")
	public String writeContentProcess(FreeboardVO freeboardVO, HttpSession session) {
		
		MemberVO sessionUser = (MemberVO)session.getAttribute("sessionUser");
		int member_no = sessionUser.getMember_no();
		freeboardVO.setMember_no(member_no);
		
		freeboardService.inserContent(freeboardVO);
		
		
		return "redirect:./mainPage.do";
	}
	
	
}
