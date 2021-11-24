<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Join</title>
    <style>
        html {height: 100%;}
        .position {
            height: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;
        }
    </style>
</head>
<body class="position">
    <h1>회원가입</h1>
    <div>${requestScope.err}</div>
    <form action="/user/join" method="post">
    <div>
        <div><input type="text" name="uid" placeholder="USER ID"></div>
        <div><input type="password" name="upw" placeholder="PASSWORD"></div>
        <div><input type="text" name="nm" placeholder="NAME"></div>
        <div>
            GENDER :
            <label><input type="radio" name="gender" value="0">woman</label>
            <label><input type="radio" name="gender" value="1">man</label>
        </div>
        <div><input type="submit" value="join"></div>
    </div>
    </form>
</body>
</html>
