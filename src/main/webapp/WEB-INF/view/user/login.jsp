<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        html {height: 100%;}
        .position {
            height: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;
        }
    </style>
</head>
<body class="position">
    <div style="color: red;">${requestScope.err}</div>
    <h1>로그인</h1>
    <form action="/user/login" method="post">
        <div>
            <div><input type="text" name="uid" placeholder="USER ID"></div>
            <div><input type="password" name="upw" placeholder="PASSWORD"></div>
            <div>
                <input type="submit" value="login">
                <a href="/user/join"><input type="button" value="join"></a>
            </div>
        </div>
    </form>
    <div style="margin-top: 30px;"><a href="/board/list"><input type="button" value="리스트로 이동"></a></div>

</body>
</html>
