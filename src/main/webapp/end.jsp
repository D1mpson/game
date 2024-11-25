<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Adventure Game - End</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h1>
        <c:choose>
            <c:when test="${gameResult == 'win'}">
                Перемога!
            </c:when>
            <c:otherwise>
                Поразка!
            </c:otherwise>
        </c:choose>
    </h1>
    <p>${endingMessage}</p>

    <!-- Відображення зображення залежно від результату -->
    <div class="image-container">
        <img src="${pageContext.request.contextPath}/images/win_or_lose/${gameResult}.png"
             alt="${gameResult}"
             class="game-image">
    </div>

    <!-- Кнопки дій -->
    <form action="game" method="get">
        <button type="submit" class="button">Почати заново</button>
    </form>
    <form action="welcome" method="get">
        <button type="submit" class="button">Головне меню</button>
    </form>
</div>
</body>
</html>
