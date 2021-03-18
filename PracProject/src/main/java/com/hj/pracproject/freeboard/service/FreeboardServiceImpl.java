package com.hj.pracproject.freeboard.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.pracproject.freeboard.mapper.FreeboardSQLMapper;
import com.hj.pracproject.member.mapper.MemberSQLMapper;
import com.hj.pracproject.vo.FreeboardVO;
import com.hj.pracproject.vo.MemberVO;

@Service
public class FreeboardServiceImpl {

	@Autowired
	private FreeboardSQLMapper freeboardSQLMapper;
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void inserContent(FreeboardVO freeboardVO) {
		freeboardSQLMapper.insertContent(freeboardVO);
		
	}
	
	public ArrayList<HashMap<String, Object>> getFreeboardList() {
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		ArrayList<FreeboardVO> freeboardList = freeboardSQLMapper.selectAll();
		
		for (FreeboardVO freeboardVO : freeboardList) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			MemberVO memberVO = memberSQLMapper.selectByNo(freeboardVO.getMember_no());
			
			map.put("freeboardVO", freeboardVO);
			map.put("memberVO", memberVO);
			
			list.add(map);
		}
		
		return list;
	}
	
}
