var currentUser;
var tableUser;
$(document).ready(
    function(){
        tableUser = new TableUser();
        $("#showEventAdd").click(function () {
            $("#edit_div").show();
            $("#del").hide();
            $("#upd").hide();
        })
        $("#add").click(function () {
            currentUser = new User();
            currentUser.login = $("#name").val();
            currentUser.add();
            clearEditArea();
        })
        $("#upd").click(function () {
            currentUser.login = $("#name").val();
            currentUser.update();
        })
        $("#del").click(function () {
            currentUser.delete();
            clearEditArea();
            $(edit_div).hide();

        })

        $("#name").focus(function () {
            if($("#name").val()=="введите имя пользователя" || $("#name").val().trim()=="") {
                $("#name").removeClass("no_active");
                $("#name").addClass("active");
                $("#name").val("");
            }
        })

        $("#name").focusout(function () {
            if($("#name").val().trim()=="") {
                $("#name").removeClass("active");
                $("#name").addClass("no_active");
                $("#name").val("введите имя пользователя");
            }
        })
    }
)

function User()
{
    var id;
    var login;
    this.add = function() {
        if(this.login!=null && this.login!="" && this.login!="введите имя пользователя"){
            $.ajax({
                url: "create/user",
                data: {login: this.login},
                method:"GET",
                success:function (dataUser) {
                    this.id=dataUser.id;
                    this.login=dataUser.login;
                    tableUser.addRow(dataUser);
                }})
        }
    }
    this.delete = function () {
        $.ajax({
            url: "delete/user",
            data: JSON.stringify(this),
            method:"POST",
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            success:function () {
                this.id=null;
                this.login=null;
                tableUser.deleteRow();
            }})
    }
    this.update = function () {
        $.ajax({
            url: "update/user",
            data: JSON.stringify(this),
            method:"POST",
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            success:function (dataUser) {
                this.id=dataUser.id;
                this.login=dataUser.login;
                tableUser.updateRow(this);
            }})
    }
}
function TableUser() {
    var table = $('#dataTable').DataTable({
            ajax: {
                url: "search-all/user",
                dataSrc: ""
            },
            aoColumns: [
                { mData: "id" },
                { mData: "login" }
            ]
        });



    this.addRow = function (user) {
        table.row.add(user).draw( false );
    };
    this.deleteRow = function(){
        table.row('.selectedRow').remove().draw(false);
        onRowDeselect();
    };

    this.updateRow = function(user){
        table.row('.selectedRow').data(user).draw(false);
    };
    $('#dataTable tbody').on('click','tr',function () {

        selectRow(this);
    });
    function selectRow (row) {
        var data = table.row( row ).data();
        if($(row).hasClass('selectedRow'))
        {
            $(row).removeClass('selectedRow');
            onRowDeselect();
        }
        else
        {
            table.$('tr.selectedRow').removeClass('selectedRow');
            $(row).addClass('selectedRow');
            onRowSelect(data);
        }
    }

}
function  onRowSelect(rowData) {
    currentUser = new User();
    currentUser.id=rowData.id;
    currentUser.login = rowData.login;
    $("#name").val(rowData.login);
    $("#name").removeClass("no_active");
    $("#name").addClass("active");
    $("#showEventAdd").hide();
    $("#del").show();
    $("#upd").show();
    $("#add").hide();
    $("#edit_div").show();
}
function onRowDeselect(){
    $("#add").show();
    $("#edit_div").hide();
    $("#showEventAdd").show();
    clearEditArea();
    currentUser=null;
}
function clearEditArea() {
    $("#name").val("");
    $("#name").focusout();
}