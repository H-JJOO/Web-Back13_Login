<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Write</title>
</head>
<body>
    <h1>글쓰기</h1>
    <div>${requestScope.err}</div>
    <form action="/board/write" method="post">
        <div>
            <div><input type="text" name="title" placeholder="TITLE" value="${requestScope.data}"></div>
            <div><textarea name="ctnt" placeholder="CONTENT" rows="20">${requestScope.data}</textarea></div>
            <div>
                <input type="submit" value="글등록">
                <input type="reset" value="초기화">
                <a href="/board/list"><input type="button" value="리스트로 이동"></a>
            </div>
        </div>
    </form>


</body>
</html>
