<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>회원가입 페이지</title>
</head>
<body>
    <h1>회원가입</h1>
    <form action="/signup" method="post">
        <sec:csrfInput/>
        <input name="username" placeholder="아이디">
        <input name="password" placeholder="비밀번호">
        <input name="purpose" placeholder="사용목적">
        <button>가입하기</button>
    </form>
</body>
</html>
