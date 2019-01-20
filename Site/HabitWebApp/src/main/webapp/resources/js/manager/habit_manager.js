var currentHabit;
var tableHabit;
$(document).ready(
    function(){
        tableHabit = new TableHabit();
        $("#showEventAdd").click(function () {
            $("#edit_div").show();
            $("#del").hide();
            $("#upd").hide();
        })
        $("#add").click(function () {
            currentHabit = new Habit();
            currentHabit.name = $("#name").val();
            currentHabit.add();
            clearEditArea();
        })
        $("#upd").click(function () {
            currentHabit.name = $("#name").val();
            currentHabit.update();
        })
        $("#del").click(function () {
            currentHabit.delete();
            clearEditArea();
            $(edit_div).hide();

        })

        $("#name").focus(function () {
            if($("#name").val()=="введите название привычки" || $("#name").val().trim()=="") {
                $("#name").removeClass("no_active");
                $("#name").addClass("active");
                $("#name").val("");
            }
        })

        $("#name").focusout(function () {
            if($("#name").val().trim()=="") {
                $("#name").removeClass("active");
                $("#name").addClass("no_active");
                $("#name").val("введите название привычки");
            }
        })
    }
)

function Habit()
{
    var id;
    var name;
    this.add = function() {
        if(this.name!=null && this.name!="" && this.name!="введите название привычки"){
            $.ajax({
                url: "create/habit",
                data: {name: this.name},
                method:"GET",
                success:function (dataHabit) {
                    this.id=dataHabit.id;
                    this.name=dataHabit.name;
                    tableHabit.addRow(dataHabit);
                }})
        }
    }
    this.delete = function () {
        $.ajax({
            url: "delete/habit",
            data: JSON.stringify(this),
            method:"POST",
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            success:function () {
                this.id=null;
                this.name=null;
                tableHabit.deleteRow();
            }})
    }
    this.update = function () {
        $.ajax({
            url: "update/habit",
            data: JSON.stringify(this),
            method:"POST",
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            success:function (dataHabit) {
                this.id=dataHabit.id;
                this.name=dataHabit.name;
                tableHabit.updateRow(this);
            }})
    }
}
function TableHabit() {
    var table = $('#dataTable').DataTable({
            ajax: {
                url: "search-all/habit",
                dataSrc: ""
            },
            aoColumns: [
                { mData: "id" },
                { mData: "name" }
            ]
        });



    this.addRow = function (habit) {
        table.row.add(habit).draw( false );
    };
    this.deleteRow = function(){
        table.row('.selectedRow').remove().draw(false);
        onRowDeselect();
    };

    this.updateRow = function(habit){
        table.row('.selectedRow').data(habit).draw(false);
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
    currentHabit = new Habit();
    currentHabit.id=rowData.id;
    currentHabit.name = rowData.name;
    $("#name").val(rowData.name);
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
    currentHabit=null;
}
function clearEditArea() {
    $("#name").val("");
    $("#name").focusout();
}