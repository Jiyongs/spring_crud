<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

	<a href="${root}/board/mappyjson?path=c" class="btn btn-primary" roll="button">mappyjson추가</a>
	<a href="${root}/board/rawjson?path=c" class="btn btn-primary" roll="button">rawjson추가</a>
	<a href="${root}/board/write?no=6&title=룰라랄라" class="btn btn-primary pull-right" roll="button">글쓰기</a>
	<a href="${root}/board/modify?no=6" class="btn btn-primary pull-right" roll="button">글수정</a>
	<a href="${root}/board/delete?no=6" class="btn btn-primary pull-right" roll="button">글삭제</a>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>상호명</th>
				<th>주소</th>
				<th>위도</th>
				<th>경도</th>
				<th>생성일자</th>
				<th>갱신일자</th>
				<th>갱신분류</th>
				<th>갱신횟수</th>
			</tr>
		</thead>
		<tbody>
		
<c:forEach var="poi" items="${mappyPois}" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${poi.pname}</td>
				<td>${poi.address}</td>
				<td>${poi.latitude}</td>
				<td>${poi.longitude}</td>
				<td>${poi.insert_date}</td>
				<td>${poi.update_date}</td>
				<td>${poi.update_code}</td>
				<td>${poi.update_cnt}</td>
			</tr>
</c:forEach>

		</tbody>
	</table>
	
	<hr/>
	
	<div class="row text-center" style="width: 100%">
		<ul class="pagination" style="float:none; margin:0 auto;">
			<li class="active"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
	</div>
	
	
<%@ include file="/WEB-INF/views/template/footer.jsp" %>