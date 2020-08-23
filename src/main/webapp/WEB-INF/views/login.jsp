<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
    <h1>로그인</h1>
    <form action="/login" method="post">
        <sec:csrfInput/>
        <input name="username" placeholder="아이디">
        <input name="password" placeholder="비밀번호">
        <button>로그인</button>
    </form>
</body>
</html>
