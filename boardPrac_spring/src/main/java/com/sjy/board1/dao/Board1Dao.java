package com.sjy.board1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sjy.board1.model.Board1Dto;

public interface Board1Dao {
	
	// 글 목록 조회
	public List<Board1Dto> getPostList();
	
	// 글 상세 조회
	public Board1Dto getPost(int postNo);
	
	// 글 등록
	public void writePost(Board1Dto dto);
	
	// 글 수정
	public void modifyPost(int postNo);
	
	// 글 삭제
	public void deletePost(int postNo);

}
