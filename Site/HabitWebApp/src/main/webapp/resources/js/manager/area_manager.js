var currentArea;
var tableArea;
$(document).ready(
    function(){
        tableArea = new TableArea();
        $("#showEventAdd").click(function () {
            $("#edit_div").show();
            $("#del").hide();
            $("#upd").hide();
        })
        $("#add").click(function () {
            currentArea = new Area();
            currentArea.name = $("#name").val();
            currentArea.add();
            clearEditArea();
        })
        $("#upd").click(function () {
            currentArea.name = $("#name").val();
            currentArea.update();
        })
        $("#del").click(function () {
            currentArea.delete();
            clearEditArea();
            $(edit_div).hide();

        })

        $("#name").focus(function () {
            if($("#name").val()=="введите название области" || $("#name").val().trim()=="") {
                $("#name").removeClass("no_active");
                $("#name").addClass("active");
                $("#name").val("");
            }
        })

        $("#name").focusout(function () {
            if($("#name").val().trim()=="") {
                $("#name").removeClass("active");
                $("#name").addClass("no_active");
                $("#name").val("введите название области");
            }
        })
    }
)

function Area()
{
    var id;
    var name;
    this.add = function() {
        if(this.name!=null && this.name!="" && this.name!="введите название области"){
            $.ajax({
                url: "create/area",
                data: {name: this.name},
                method:"GET",
                success:function (dataArea) {
                    this.id=dataArea.id;
                    this.name=dataArea.name;
                    tableArea.addRow(dataArea);
                }})
        }
    }
    this.delete = function () {
        $.ajax({
            url: "delete/area",
            data: JSON.stringify(this),
            method:"POST",
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            success:function () {
                this.id=null;
                this.name=null;
                tableArea.deleteRow();
            }})
    }
    this.update = function () {
        $.ajax({
            url: "update/area",
            data: JSON.stringify(this),
            method:"POST",
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            success:function (dataArea) {
                this.id=dataArea.id;
                this.name=dataArea.name;
                tableArea.updateRow(this);
            }})
    }
}
function TableArea() {
    var table = $('#dataTable').DataTable({
            ajax: {
                url: "search-all/area",
                dataSrc: ""
            },
            aoColumns: [
                { mData: "id" },
                { mData: "name" }
            ]
        });



    this.addRow = function (area) {
        table.row.add(area).draw( false );
    };
    this.deleteRow = function(){
        table.row('.selectedRow').remove().draw(false);
        onRowDeselect();
    };

    this.updateRow = function(area){
        table.row('.selectedRow').data(area).draw(false);
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
    currentArea = new Area();
    currentArea.id=rowData.id;
    currentArea.name = rowData.name;
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
    currentArea=null;
}
function clearEditArea() {
    $("#name").val("");
    $("#name").focusout();
}