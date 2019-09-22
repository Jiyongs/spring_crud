package com.sjy.board1.service;

import java.util.List;
import java.util.Map;

import com.sjy.board1.model.Board1Dto;

public interface Board1Service {

	// 글 목록 조회
	List<Board1Dto> getPostList();

	// 글 상세 조회
	Board1Dto getPost(int postNo);

	// 글 등록
	void writePost(Board1Dto dto);

	// 글 수정
	void modifyPost(int postNo);

	// 글 삭제
	void deletePost(int postNo);

}
