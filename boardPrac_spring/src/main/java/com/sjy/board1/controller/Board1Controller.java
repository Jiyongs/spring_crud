package com.sjy.board1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sjy.board1.model.Board1Dto;
import com.sjy.board1.model.MappyPoiDto;
import com.sjy.board1.service.Board1Service;

@Controller
@RequestMapping("/board")
public class Board1Controller {

	// [response method]

	@Autowired
	private Board1Service board1Service;

	// 1 페이지 이동
	@RequestMapping(method = RequestMethod.GET)
	public String mvBoard(Model model) {

		System.out.println("Board1Controller : mvBoard() ");
		List<MappyPoiDto> poiList = board1Service.getMappyPoiList();
		model.addAttribute("mappyPois", poiList);

		return "/board/board1";
	}

	// 2 수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(@RequestParam("no") int no) {
		System.out.println("Board1Controller : modify() ");

		System.out.println("받은 인자 값 : " + no);
		board1Service.modifyPost(no);

		return "/board/board1";
	}

	// 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("no") int no) {
		System.out.println("Board1Controller : delete() ");

		System.out.println("받은 인자 값 : " + no);

		board1Service.deletePost(no);

		return "/board/board1";
	}

	// 생성
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


	// insert into mappy_poi table
	@RequestMapping(value = "/mappyjson", method = RequestMethod.GET)
	public String insertMappyPoi(Model model, @RequestParam("path") String path) {

		System.out.println("Board1Controller : readJson() ");
		System.out.println("Board1Controller : 받아온 JSON파일 경로 : " + path);

		String result = board1Service.insertMappyPoi("c:\\\\rawdata.json");
		
		model.addAttribute("result", result);

		return "/board/result/bresult";
	}
	
	// insert into rawdata_poi table
	@RequestMapping(value = "/rawjson", method = RequestMethod.GET)
	public String insertRawPoi(Model model, @RequestParam("path") String path) {

		System.out.println("Board1Controller : readJson() ");
		System.out.println("Board1Controller : 받아온 JSON파일 경로 : " + path);

		String result = board1Service.insertRawDataPoi("c:\\\\rawdata.json");
		
		model.addAttribute("result", result);

		return "/board/result/bresult";
	}

	
}
