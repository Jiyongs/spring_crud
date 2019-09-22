<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<!-- *** 참고사항 *** -->

<!-- [DB 정보]

ID : javaboard / pw : 1234 
	
create table member(
	id varchar(50),
	pass varchar(50),
	name varchar(50),
	constraint member_pk primary key(id)
);

create table board1(
	no number,
	title varchar2(50) default 'no title',
	id varchar2(50),
	postdate date default sysdate,
	viewcount number default 0,
	constraint board1_pk primary key(no),
	constraint board1_fk foreign key(id) references member(id)
);

-->

<!-- [GET 페이지 이동 방법] -->
<a href="${root}/mvb1">1. a태그로 이동</a>
</br>
<button onclick="location.href='${root}/mvb1'">2. 일반 버튼으로 이동</button>
</br>
<input type="button" value="3. 인풋 버튼으로 이동" onclick="location.href='${root}/mvb1'">


<%@ include file="/WEB-INF/views/template/footer.jsp" %>

<!-- [디버깅 방법]

log.debug("디버그 로그 시험");
log.error("에러 로그 시험");
log.info("인포 로그 시험");
log.warn("경고 로그 시험");

-->
