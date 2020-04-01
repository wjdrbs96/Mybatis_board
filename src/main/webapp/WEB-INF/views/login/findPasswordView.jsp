<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 찾았음</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/res/js/findpw.js"></script>
</head>
<body>
<div class="container text-center login-margin-top">
    <div>
        <h1>비밀번호 찾기</h1>
    </div>
    <hr>
    <form method="get">
        <input type="hidden" name="password" value="findpw">
        <h3>당신의 비밀번호는 ${password} 입니다</h3>
        <div>
            <a href="http://localhost:8080/login" class="btn btn-info">로그인</a>
        </div>
    </form>
</div>

</body>
</html>