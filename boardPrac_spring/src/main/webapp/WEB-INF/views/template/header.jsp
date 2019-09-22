<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>spring+java로 만드는 게시판</title>
</head>
<body>

<!-- 상단 메뉴  -->
 <nav class="navbar navbar-default">
  <div class="navbar-header">

   <button type="button" class="navbar-toggle collapsed" 
    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
    aria-expaned="false">
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
   </button>

    <a class="navbar-brand" href="index.jsp">JSP 게시판</a>

  </div>

  <div class="collapse navbar-collapse" id="#bs-example-navbar-collapse-1">

   <ul class="nav navbar-nav">
    <li><a href="index.jsp">HOME</a></li>
    <li><a href="${root}/board/">Board1</a></li>
   </ul>

   <ul class="nav navbar-nav navbar-right">
    <li class="dropdown">
     <a href="#" class="dropdown-toggle"
      data-toggle="dropdown" role="button" aria-haspopup="true"
      aria-expanded="false">LOGIN/JOIN<span class="caret"></span></a>
     <ul class="dropdown-menu">
      <li class="active"><a href="${root}/mvlogin">로그인</a></li>
      <li><a href="${root}/mvjoin">회원가입</a></li>
     </ul>
    </li>
   </ul>

  </div> 

 </nav>

<!-- Container 시작 -->
<div class="container">
