package com.sjy.board1.service;

import java.util.List;

import com.sjy.board1.model.Board1Dto;
import com.sjy.board1.model.MappyPoiDto;

public interface Board1Service {

	// 글 목록 조회
	List<MappyPoiDto> getMappyPoiList();

	// 글 상세 조회
	Board1Dto getPost(int postNo);

	// 글 등록
	void writePost(Board1Dto dto);

	// 글 수정
	void modifyPost(int postNo);

	// 글 삭제
	void deletePost(int postNo);

	// MappyPoi 데이터 등록 (사이트 구동 후 최초 한번)
	String insertMappyPoi(String path);
	
	// RawdataPoi 데이터 등록
	String insertRawDataPoi(String path);

}
