<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        input.form-control, select.form-control {
            width: 200px;
        }
        h1 {
            margin-top: 50px;
        }
    </style>
</head>
<body>

<div class="container">
    <a href="http://localhost:8080/register"><h1 style="color: #0000FF;">회원가입</h1></a>
    <hr />

    <form action="http://localhost:8080/register" method="post">
        <div class="form-group">
            <label>사용자 아이디</label>
            <input type="text" class="form-control" name="loginId" value="${member.loginId}" placeholder="아이디를 입력하세요.">
        </div>
        <div class="form-group">
            <label>비밀번호</label>
            <input type="password" class="form-control" name="password1" value="${member.password}" placeholder="비밀번호를 입력하세요.">
        </div>
        <div class="form-group">
            <label>비밀번호 재확인</label>
            <input type="password" class="form-control" name="password2" value="${password2}" placeholder="비밀번호 재입력하세요."/>
        </div>
        <div class="form-group">
            <label>이름</label>
            <input type="text" class="form-control" name="name" value="${member.name}" placeholder="이름을 입력하세요."/>
        </div>
        <div class="form-group">
            <label>닉네임</label>
            <input type="text" class="form-control" name="nickname" value="${member.nickName}" placeholder="별명을 입력하세요."/>
        </div>
        <div class="form-group">
            <label>이메일</label>
            <input type="email" class="form-control" name="email" value="${member.email}" placeholder="이메일을 입력하세요."/>
        </div>

        <button type="submit" class="btn btn-primary">
            <i class="glyphicon glyphicon-ok"></i> 회원가입
        </button>
        <a href="http://localhost:8080/login" class="btn btn-default">처음으로</a>
    </form>

    <hr />
    <c:if test="${error != null}">
        <div class="alert alert-danger">
            회원가입 실패: ${error}
        </div>
    </c:if>

</div>
</body>
</html>