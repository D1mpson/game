<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Adventure Game - In Progress</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<div class="container">

    <img src="${pageContext.request.contextPath}/images/nickname.png" alt="Adventure Game Logo" class="logo">

    <h1>Введіть ваш нікнейм</h1>
    <form action="${pageContext.request.contextPath}/game" method="post">
        <div class="form-group">
            <input type="text" name="playerName" required>
        </div>
        <button type="submit">Почати гру</button>
    </form>
    <form action="welcome" method="get">
        <button type="submit" class="button">Повернутись назад</button>
    </form>
</div>
</body>
</html>