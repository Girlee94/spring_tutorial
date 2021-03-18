package com.hj.pracproject.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.pracproject.member.mapper.MemberSQLMapper;
import com.hj.pracproject.vo.MemberVO;

@Service
public class MemberServiceImpl {

	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void joinMember(MemberVO memberVO) {
		
		memberSQLMapper.insert(memberVO);
	}
	
	public MemberVO login(MemberVO param) {
		
		MemberVO result = memberSQLMapper.selectByIdAndPw(param);
		
		return result;
	}
	
}
