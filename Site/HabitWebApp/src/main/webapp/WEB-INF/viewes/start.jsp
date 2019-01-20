<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/resources/css/style.css" var="cssUrl"/>
<link rel="stylesheet" type="text/css" href="${cssUrl}"/>

<script type="text/javascript" src="/resources/js/start.js"></script>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="box">
        <p>Пользователи</p>
        <a class="button" href="user_manager">GO</a>
    </div>

    <div class="box">
        <p>Привычки</p>
        <a class="button" href="area_habit_manager">GO</a>
    </div>

    <div class="box">
        <p>Архив</p>
        <a class="button"  href="archive_manager">GO</a>
    </div>

    <div class="box">
        <p>Стратегия</p>
        <a class="button"  href="strategy_manager">GO</a>
    </div>
</body>
</html>
