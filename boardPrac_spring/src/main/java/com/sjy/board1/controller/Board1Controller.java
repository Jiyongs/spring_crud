package com.sjy.board1.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
		
		System.out.println("Board1Controller : mvBoard() ");
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
	
	@RequestMapping(value = "/readjson", method = RequestMethod.GET)
	public String readJson(Model model) {
		
		System.out.println("Board1Controller : readJson() ");

		JSONParser par = new JSONParser();
		
		try {
			
			// json파일을 버퍼에 읽어 옴
			FileInputStream ins = new FileInputStream("c:\\\\rawdata.json");
			InputStreamReader inr = new InputStreamReader(ins, "UTF-8");
			BufferedReader br = new BufferedReader(inr);

			StringBuffer sb = new StringBuffer();
			
			String line = "";
			while((line = br.readLine()) != null) {
				sb.append(line);
				sb.append('\n');
			}
			br.close();
			
			String strJson = sb.toString();
			System.out.println("strJson : " + strJson);
			
			// json파일을 올바른 형식으로 변환			
			strJson = strJson.replace("}\n", "},\n");
			strJson = strJson.substring(0, strJson.length()-2);
			strJson = "[" + strJson + "]";
			System.out.println(strJson);	
			
			// json을 파싱하여 사용
			JSONArray jsonArr = (JSONArray) par.parse(strJson);
			System.out.println(jsonArr);
			
			int jsonSize = jsonArr.size();
			for(int i = 0; i < jsonSize; i ++) {
				JSONObject postObj = (JSONObject) jsonArr.get(i);
				String id = (String) postObj.get("_id");
				System.out.println("id : " + id);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return "/board/board1";
	}

}
