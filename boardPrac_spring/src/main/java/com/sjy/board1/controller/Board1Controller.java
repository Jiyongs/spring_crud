package com.sjy.board1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sjy.board1.model.Board1Dto;
import com.sjy.board1.service.Board1Service;

@Controller
@RequestMapping("/board")
public class Board1Controller {
	
	@Autowired
	private Board1Service board1Service;
	
	// 1 페이지 이동
	@RequestMapping(method = RequestMethod.GET)
	public String mvBoard(Model model) {
		
		System.out.println("Board1Controller 실행");
		List<Board1Dto> postList = board1Service.getPostList();
		model.addAttribute("posts", postList);
		
		return "/board/board1";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(@RequestParam("no") int no) {
		System.out.println("Board1Controller : modify() ");
		
		System.out.println("받은 인자 값 : " + no);
		board1Service.modifyPost(no);
		
		return "/board/board1";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("no") int no) {
		System.out.println("Board1Controller : delete() ");
		
		System.out.println("받은 인자 값 : " + no);

		board1Service.deletePost(no);
			
		return "/board/board1";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(@RequestParam("no") int no, @RequestParam("title") String title) {
		System.out.println("Board1Controller : write() ");
		
		System.out.println("받은 인자 값 : " + no);
		System.out.println("받은 인자 값 : " + title);
		
		Board1Dto dto = new Board1Dto();
		dto.setNo(no);
		dto.setTitle(title);
		board1Service.writePost(dto);
		
		return "/board/board1";		
	}
}
