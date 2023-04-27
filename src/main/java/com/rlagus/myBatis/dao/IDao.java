package com.rlagus.myBatis.dao;

import java.util.ArrayList;
import com.rlagus.myBatis.dto.BoardDto;

public interface IDao {										// 추장 클래스로 dao 생성

	public void writeDao(String mwriter, String mcontent);	// 게시판 글 쓰기 (추상메소드 매개변수 필요)
	public ArrayList<BoardDto> listDao();					// 게시판 리스트 가져오기 
	public void deleteDao(String mid);						// 게시판 글 지우기
	
	public int totalCount();									// 총 게시글 수 반환
}
