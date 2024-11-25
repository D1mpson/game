<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Adventure Game - In Progress</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </style>
</head>

<body>
<div class="container">
    <div class="image-container">
        <img src="${pageContext.request.contextPath}/${image}" alt="Game Scene" class="game-image">
    </div>
    <div class="question">
        <h2>${question}</h2>
    </div>
    <div class="options">
        <form action="game" method="post">
            <c:forEach items="${options}" var="option">
                <button type="submit" name="choice" value="${option}" class="button">${option}</button>
            </c:forEach>
        </form>
    </div>
    <form action="game" method="post">
        <button type="submit" name="action" value="endGame" class="button">Закінчити гру</button>
    </form>
</div>
</body>
</html>