package com.sjy.board1.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sjy.board1.dao.Board1Dao;
import com.sjy.board1.model.Board1Dto;
import com.sjy.board1.model.MappyPoiDto;
import com.sjy.board1.model.RawPoiDto;

@Service
public class Board1ServiceImpl implements Board1Service{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MappyPoiDto> getMappyPoiList() {
		
		return sqlSession.getMapper(Board1Dao.class).getMappyPoiList();
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

	
	
	@Override
	public String insertMappyPoi(String path) throws DataAccessException {

		System.out.println("파일 경로 : " + path);
		
		String result = "";

		int totalCnt = 0;
		int failCnt = 0;
		int sameCnt = 0;
		
		JSONParser par = new JSONParser();

		try {

			// json파일 string으로 받아오기
			String strJson = toJsonStr(path);
			
			// # json파일이 유효한 경우
			if(strJson != "") {
				
				// json을 파싱하여 사용
				JSONArray jsonArr = (JSONArray) par.parse(strJson);
				
				int jsonSize = jsonArr.size();
				totalCnt += jsonSize;
				for (int i = 0; i < jsonSize; i++) {
					JSONObject postObj = (JSONObject) jsonArr.get(i);
					
					// ## 주소 정보가 있는 경우
					if(postObj.get("map_address_array") != null) {
						JSONArray addressArr = (JSONArray) postObj.get("map_address_array");
						JSONArray pnameArr = (JSONArray) postObj.get("map_brand_array");
						JSONArray latitudeArr = (JSONArray) postObj.get("map_latitude_array");
						JSONArray longitudeArr = (JSONArray) postObj.get("map_longitude_array");
						
						int mapSize = addressArr.size();
						totalCnt += (mapSize-1);

						List<MappyPoiDto> mapPerOne = new ArrayList<MappyPoiDto>();
						
						for(int j = 0; j < mapSize; j++) {
							MappyPoiDto mappyPoi = new MappyPoiDto();
							mappyPoi.setAddress(addressArr.get(j).toString());
							mappyPoi.setPname(pnameArr.get(j).toString());
							mappyPoi.setLatitude((double)latitudeArr.get(j));
							mappyPoi.setLongitude((double)longitudeArr.get(j));
							
							mapPerOne.add(mappyPoi);

							try {
								sqlSession.getMapper(Board1Dao.class).insertMappyPoi(mapPerOne);														
							}
							// sql 제약조건 위반 에러 처리 (중복 처리)
							 catch(DataIntegrityViolationException e) {
								sameCnt++;
								System.out.println("[" + i + "]" + e.getCause());
								continue;
							}
					
						}
						
					}
					// ## 주소 정보가 없는 경우
					else {
						failCnt++;
						System.out.println("[" + i + "]" + postObj.get("_id") + " : 주소 정보가 없습니다.");
					}
						
				}

				result = "[결과] : json파일 등록 완료(총계 : " + totalCnt + " | 성공 : " + (totalCnt - failCnt - sameCnt) + " | 중복 : " +sameCnt + " | 없음 : " + failCnt + ")";
				
			}
			// # json파일이 무효한 경우
			else {
				result = "[에러] : json파일 경로가 잘못되었습니다.";
			}


		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		return result;
		
	}
	
	
	
	@Override
	public String insertRawDataPoi(String path) throws DataAccessException {
		
		System.out.println("파일 경로 : " + path);
		
		String result = "";

		int totalCnt = 0;
		int failCnt = 0;
		int sameCnt = 0;
		
		JSONParser par = new JSONParser();

		try {

			// json파일 string으로 받아오기
			String strJson = toJsonStr(path);
			
			// # json파일이 유효한 경우
			if(strJson != "") {
				
				// json을 파싱하여 사용
				JSONArray jsonArr = (JSONArray) par.parse(strJson);
				
				int jsonSize = jsonArr.size();
				totalCnt += jsonSize;
				for (int i = 0; i < jsonSize; i++) {
					JSONObject postObj = (JSONObject) jsonArr.get(i);
					
					// ## 주소 정보가 있는 경우
					if(postObj.get("map_address_array") != null) {
						JSONArray addressArr = (JSONArray) postObj.get("map_address_array");
						JSONArray pnameArr = (JSONArray) postObj.get("map_brand_array");
						JSONArray latitudeArr = (JSONArray) postObj.get("map_latitude_array");
						JSONArray longitudeArr = (JSONArray) postObj.get("map_longitude_array");
						
						int mapSize = addressArr.size();
						totalCnt += (mapSize-1);

						List<RawPoiDto> mapPerOne = new ArrayList<RawPoiDto>();
						
						for(int j = 0; j < mapSize; j++) {
							RawPoiDto rawPoi = new RawPoiDto();
							rawPoi.setRid(postObj.get("_id").toString());
							rawPoi.setAddress(addressArr.get(j).toString());
							rawPoi.setPname(pnameArr.get(j).toString());
							rawPoi.setLatitude((double)latitudeArr.get(j));
							rawPoi.setLongitude((double)longitudeArr.get(j));
							String date = (String)postObj.get("write_date_dt");
							date = date.substring(0, 19);
							System.out.println(date);
							rawPoi.setWrite_date(date);
							
							mapPerOne.add(rawPoi);
							System.out.println(rawPoi);

							try {
								sqlSession.getMapper(Board1Dao.class).insertRawDataPoi(mapPerOne);														
							}
							// sql 제약조건 위반 에러 처리 (중복 처리)
							 catch(DataIntegrityViolationException e) {
								sameCnt++;
								System.out.println("[" + i + "]" + e.getCause());
								continue;
							}
					
						}
						
					}
					// ## 주소 정보가 없는 경우
					else {
						failCnt++;
						System.out.println("[" + i + "]" + postObj.get("_id") + " : 주소 정보가 없습니다.");
					}
						
				}

				result = "[결과] : json파일 등록 완료(총계 : " + totalCnt + " | 성공 : " + (totalCnt - failCnt - sameCnt) + " | 중복 : " +sameCnt + " | 없음 : " + failCnt + ")";
				
			}
			// # json파일이 무효한 경우
			else {
				result = "[에러] : json파일 경로가 잘못되었습니다.";
			}


		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		return result;
		
	}

	
	
	
	
	// [etc method]

	/**
	 1) toJsonStr()
	 parameter
	 - path : json파일 저장 경로
	 return
	 - O    : json파일을 문자열로 변환한 String
	 */
	public String toJsonStr(String path) {

		String strJson = "";
		
		try {
			// json파일을 버퍼에 읽어 옴
			FileInputStream ins = new FileInputStream(path);
			InputStreamReader inr = new InputStreamReader(ins, "UTF-8");
			BufferedReader br = new BufferedReader(inr);

			StringBuffer sb = new StringBuffer();

			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append('\n');
			}

			br.close();

			strJson = sb.toString();
			
			// json파일을 올바른 형식으로 변환
			strJson = strJson.replace("}\n", "},\n");
			strJson = strJson.substring(0, strJson.length() - 2);
			strJson = "[" + strJson + "]";
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return strJson;
	}



}
