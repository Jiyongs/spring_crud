package com.sjy.board1.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjy.board1.dao.Board1Dao;
import com.sjy.board1.model.Board1Dto;

@Service
public class Board1ServiceImpl implements Board1Service{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Board1Dto> getPostList() {
		
		return sqlSession.getMapper(Board1Dao.class).getPostList();
	}

	@Override
	public Board1Dto getPost(int postNo) {
		
		return sqlSession.getMapper(Board1Dao.class).getPost(postNo);
	}

	@Override
	public void writePost(Board1Dto dto) {
		
		sqlSession.getMapper(Board1Dao.class).writePost(dto);
	}

	@Override
	public void modifyPost(int postNo) {
		
		sqlSession.getMapper(Board1Dao.class).modifyPost(postNo);
	}

	@Override
	public void deletePost(int postNo) {
		
		sqlSession.getMapper(Board1Dao.class).deletePost(postNo);
	}

}
