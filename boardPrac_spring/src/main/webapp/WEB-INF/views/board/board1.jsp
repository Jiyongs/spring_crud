<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
		
<c:forEach var="post" items="${posts}">
			<tr>
				<td>${post.no}</td>
				<td>${post.title}</td>
				<td>${post.writer}</td>
				<td>${post.postdate}</td>
				<td>${post.viewcount}</td>
			</tr>
</c:forEach>

		</tbody>
	</table>
	
	<hr/>
	<a href="${root}/board/write?no=6&title=룰라랄라" class="btn btn-primary pull-right" roll="button">글쓰기</a>
	<a href="${root}/board/modify?no=6" class="btn btn-primary pull-right" roll="button">글수정</a>
	<a href="${root}/board/delete?no=6" class="btn btn-primary pull-right" roll="button">글삭제</a>
	<a href="${root}/board/readjson" class="btn btn-primary pull-right" roll="button">json읽기</a>
	
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