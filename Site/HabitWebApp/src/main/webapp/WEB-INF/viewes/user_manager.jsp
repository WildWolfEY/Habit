<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
    <c:url value="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" var="cssDataTable"/>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="resources/js/simple_manager.js"></script>
    <link rel="stylesheet" type="text/css" href="${cssDataTable}"/>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css"/>
</head>
<body>
  <div class="centerWindow">
    <div class = "left">
      <button class="button">Add</button>
        <div id="edit_div">
          <input type="text" value="введите имя пользователя"/>
          <button class="button">Ok</button>
        </div>
    </div>
    <table id = "dataTable" class="display">
      <thead>
        <tr>
          <th>id</th>
          <th>логин</th>
        </tr>
      </thead>
    </table>
  </div>
</body>
</html>
