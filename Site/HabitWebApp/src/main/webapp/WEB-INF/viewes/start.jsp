<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/resources/css/style.css" var="cssUrl"/>
<link rel="stylesheet" type="text/css" href="${cssUrl}"/>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>

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
        <a class="button" href="habit_manager">GO</a>
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
