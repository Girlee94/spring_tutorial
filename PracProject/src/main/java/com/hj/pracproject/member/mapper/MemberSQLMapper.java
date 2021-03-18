package com.hj.pracproject.member.mapper;

import com.hj.pracproject.vo.MemberVO;

public interface MemberSQLMapper {
	
	public void insert(MemberVO memberVO);
	
	public MemberVO selectByIdAndPw(MemberVO memberVO);
	
	public MemberVO selectByNo(int no);
	
}
