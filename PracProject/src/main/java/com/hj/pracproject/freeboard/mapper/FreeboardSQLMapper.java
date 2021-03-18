package com.hj.pracproject.freeboard.mapper;

import java.util.ArrayList;

import com.hj.pracproject.vo.FreeboardVO;

public interface FreeboardSQLMapper {

	public void insertContent(FreeboardVO freeboardVO);
	
	public ArrayList<FreeboardVO> selectAll();
	
}
