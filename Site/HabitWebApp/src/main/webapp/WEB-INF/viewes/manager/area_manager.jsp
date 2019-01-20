<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Области</title>
    <%--<c:url value="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" var="cssDataTable"/>--%>
    <%--<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>--%>
    <%--<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>--%>

    <script type="text/javascript" src="resources/js/jQuery_3.3.1.js"></script>
    <script type="text/javascript" src="resources/js/DataTables.js"></script>
    <script type="text/javascript" src="resources/js/manager/area_manager.js"></script>

    <link rel="stylesheet" type="text/css" href="resources/css/DataTableStyle.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css"/>
</head>
<body>
  <div class="centerWindow">
    <div class = "left">
      <button class="button" id="showEventAdd">Add</button>
        <div id="edit_div" style="display: none">
            <input type="text" value="введите название области" class="no_active" id="name"/>
            <button class="button" id="add">Ok</button>
            <button class="button" id="upd">Upd</button>
            <button class="button" id="del">Del</button>
        </div>

    </div>
    <table id = "dataTable" class="display">
      <thead>
        <tr>
          <th>id</th>
          <th>Область</th>
        </tr>
      </thead>
    </table>
  </div>
</body>
</html>
