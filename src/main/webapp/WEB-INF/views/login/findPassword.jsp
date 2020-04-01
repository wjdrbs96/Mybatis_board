<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 찾기</title>
    <script src="${pageContext.request.contextPath}/res/js/findpw.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container text-center login-margin-top">
    <div>
        <h1>비밀번호 찾기</h1>
    </div>
    <hr>

    <form action="" method="post">

        <div class="form-group">
            <input class="form-control" type="text" id="id" name="loginId" placeholder="ID를 입력하세요.">

        </div>

        <div class="form-group">
            <input  class="form-control" type="text" id="name" name="name" placeholder="이름을 입력하세요.">

        </div>

        <hr>
        <div>
            <a href="http://localhost:8080/login" class="btn btn-info">로그인</a>
            <button class="btn btn-primary" type="submit" onclick="validate();">비밀번호 찾기</button>
        </div>
    </form>
</div>
</body>
</html>