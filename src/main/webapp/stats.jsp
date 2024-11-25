<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Adventure Game - In Progress</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h1>Статистика гравців</h1>
    <table>
        <tr>
            <th>Нікнейм</th>
            <th>Ігор зіграно</th>
            <th>Перемоги</th>
            <th>Поразки</th>
        </tr>
        <c:forEach items="${stats}" var="entry">
            <tr>
                <td>${entry.key}</td>
                <td>${entry.value.gamesPlayed}</td>
                <td>${entry.value.wins}</td>
                <td>${entry.value.losses}</td>
            </tr>
        </c:forEach>
    </table>
    <form action="welcome" method="get">
        <button type="submit" class="button">Назад до головного меню</button>
    </form>
</div>
</body>
</html>