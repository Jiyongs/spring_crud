package com.sjy.board1.dao;

import java.util.List;

import com.sjy.board1.model.Board1Dto;
import com.sjy.board1.model.MappyPoiDto;
import com.sjy.board1.model.RawPoiDto;

public interface Board1Dao {
	
	// 글 목록 조회
	public List<MappyPoiDto> getMappyPoiList();
	
	// 글 상세 조회
	public Board1Dto getPost(int postNo);
	
	// 글 등록
	public void writePost(Board1Dto dto);
	
	// 글 수정
	public void modifyPost(int postNo);
	
	// 글 삭제
	public void deletePost(int postNo);

	// MappyPoi 데이터 등록 (사이트 구동 후 최초 한번)
	public void insertMappyPoi(List<MappyPoiDto> mapPerOne);

	// RawPoi 데이터 등록 (json파일 등록마다)
	public void insertRawDataPoi(List<RawPoiDto> mapPerOne);

	
}
