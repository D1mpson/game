<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Adventure Game - In Progress</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <!-- Додавання картинки -->
    <img src="${pageContext.request.contextPath}/images/welcome.png" alt="Adventure Game Logo" class="logo">

    <h1>Ласкаво просимо в гру "Історія розробника"<% if (request.getAttribute("playerName") != null) { %>, <%= request.getAttribute("playerName") %><% } %>!</h1>
    <form action="welcome" method="post">
        <button type="submit" name="action" value="startGame" class="button">Почати гру</button>
    </form>
    <form action="stats" method="get">
        <button type="submit" class="button">Статистика</button>
    </form>
    <form action="welcome" method="post">
        <button type="submit" name="action" value="changeNickname" class="button">Зміна нікнейму</button>
    </form>
</div>
</body>
</html>
