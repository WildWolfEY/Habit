<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Привычки</title>
    <%--<c:url value="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" var="cssDataTable"/>--%>
    <%--<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>--%>
    <%--<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>--%>

    <script type="text/javascript" src="resources/js/jQuery_3.3.1.js"></script>
    <script type="text/javascript" src="resources/js/DataTables.js"></script>
    <script type="text/javascript" src="resources/js/manager/area_habit_manager.js"></script>

    <link rel="stylesheet" type="text/css" href="resources/css/DataTableStyle.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css"/>
</head>
<body>
<a class="button" href="area_manager">Области</a>
<a class="button" href="habit_manager">Привычки</a>
<div class="centerWindow">
    <div class="left">
        <button class="button" id="showEventAdd">Add</button>
        <div id="edit_div" style="display: none">
            <table>
                <tr>
                    <td>
                        <div class="hide_object"  id="div_area">
                            <input type="text" value="введите название области" class="no_active" id="name_area"/>
                        </div>
                        <div>
                            <select id="areas" class="edit"></select>
                        </div>
                    </td>
                    <td style="display: none">
                        <button class="button" id="add_area">Ok</button>
                        <button class="button" id="upd_area">Upd</button>
                        <button class="button" id="del_area">Del</button>
                    </td>

                    <td>
                        <div class="hide_object" id="div_habit">
                            <input type="text" value="введите название привычки" class="no_active" id="name_habit"/>
                            <div>
                                <select multiple class="edit" style="position: absolute">
                                    <option>1</option>
                                    <option>2</option>
                                </select>
                            </div>
                        </div>
                        <div>
                            <select id="habits" class="edit"></select>
                        </div>
                    </td>
                    <td style="display: none">
                        <button class="button" id="add_habit">Ok</button>
                        <button class="button" id="upd_habit">Upd</button>
                        <button class="button" id="del_habit">Del</button>
                    </td>
                </tr>
                <tr>
                    <td>

                        <button class="button" id="add">Ok</button>
                        <button class="button" id="upd">Upd</button>
                        <button class="button" id="del">Del</button>
                    </td>
                </tr>
            </table>
        </div>

    </div>
    <table id="dataTable" class="display">
        <thead>
        <tr>
            <th>id</th>
            <th>id_Области</th>
            <th>Область</th>
            <th>id_Привычки</th>
            <th>Привычка</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>
