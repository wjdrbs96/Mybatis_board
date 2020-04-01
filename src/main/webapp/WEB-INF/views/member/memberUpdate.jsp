<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/res/css/application.css" rel="stylesheet">
    <style>
        body { font-family: 굴림체; }
        input.form-control, select.form-control { width: 200px; }
        h1 {
            margin-top: 50px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>회원정보수정</h1>
    <hr />

    <form action="http://localhost:8080/member/update?memberId=${member.getMemberId()}" method="post">
        <div class="form-group">
            <label>사용자 아이디</label>
            <input type="text" class="form-control" name="loginId" value="${member.getLoginId()}">
        </div>
        <div class="form-group">
            <label>비밀번호</label>
            <input type="password" class="form-control" name="password" value="${member.getPassword()}">
        </div>
        <div class="form-group">
            <label>이름</label>
            <input type="text" class="form-control" name="name" value="${member.getName()}"/>
        </div>
        <div class="form-group">
            <label>닉네임</label>
            <input type="text" class="form-control" name="nickname" value="${member.getNickName()}"/>
        </div>
        <div class="form-group">
            <label>이메일</label>
            <input type="email" class="form-control" name="email" value="${member.getEmail()}"/>
        </div>

        <button type="submit" class="btn btn-primary">
            <i class="glyphicon glyphicon-ok"></i> 수정
        </button>
        <a href="http://localhost:8080/post/list" class="btn btn-default">게시글로</a>
    </form>

</div>
</body>
</html>