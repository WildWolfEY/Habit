var currentHabit;
var currentArea;
var currentAreaHabit;
var areas;
var habits;

var tableAreaHabit;
$(document).ready(
    function() {
        tableAreaHabit = new TableAreaHabit();
        $("#showEventAdd").click(function () {
            $("#edit_div").show();
            $("#del").hide();
            $("#upd").hide();
        })
        $("#add").click(function () {
            if($("#name_habit").class =="active")
            currentAreaHabit = new AreaHabit();
            currentAreaHabit.area = currentArea;
            currentAreaHabit.habit = currentHabit;
            currentAreaHabit.add();
        })
        $("#upd").click(function () {
            currentAreaHabit.area = currentArea;
            currentAreaHabit.habit = currentHabit;
            currentAreaHabit.update();
        })
        $("#del").click(function () {
            currentAreaHabit.delete();
            $(edit_div).hide();

        })

        $("#name_habit").focus(function () {
            if ($("#name_habit").val() == "введите название привычки" || $("#name_habit").val() == "") {
                $("#name_habit").removeClass("no_active");
                $("#name_habit").addClass("active");
                $("#name_habit").val("");
            }
        })

        $("#name_habit").focusout(function () {
            if ($("#name_habit").val().trim() == "") {
                $("#name_habit").removeClass("active");
                $("#name_habit").addClass("no_active");
                $("#name_habit").val("введите название привычки");
            }
        })
        
        $("#name_area").focus(function () {
            if ($("#name_area").val() == "введите название области" || $("#name_area").val() == "") {
                $("#name_area").removeClass("no_active");
                $("#name_area").addClass("active");
                $("#name_area").val("");
            }
        })
        $("#name_area").focusout(function () {
            if ($("#name_area").val().trim() == "") {
                $("#name_area").removeClass("active");
                $("#name_area").addClass("no_active");
                $("#name_area").val("введите название области");
            }
        })

        $("#habits").keypress(function (event) {
            if (event.keyCode != 13) {
                $(this).hide();
                $("#name_habit").val(String.fromCharCode(event.keyCode));
                $("#div_habit").show();
                $("#name_habit").removeClass("no_active");
                $("#name_habit").addClass("active");
                $("#name_habit").focus();
            }
        })
        $("#areas").keypress(function (event) {
            if (event.keyCode != 13) {
                $(this).hide();
                $("#name_area").val(String.fromCharCode(event.keyCode));
                $("#div_area").show();
                $("#name_area").removeClass("no_active");
                $("#name_area").addClass("active");
                $("#name_area").focus();
            }
        })
        // $("#areas").change(function () {
        //     currentArea = new Area();
        //     currentArea.id = $("areas option:selected").attr("value");
        //     currentArea.name = $("areas option:selected").text();
        // })


        $( "#areas" ).change(function () {
            currentArea = new Area();
            $( "#areas option:selected" ).each(function() {
                currentArea.name = $(this).text();
                currentArea.id = $(this).attr("value");
            });
        });


        $( "#habits" ).change(function () {
            currentHabit = new Habit();
            $( "#habits option:selected" ).each(function() {
                currentHabit.name = $(this).text();
                currentHabit.id = $(this).attr("value");
            });
        });
        areas = new AllAreas();
        areas.load();
        habits = new AllHabits();
        habits.load();

        // $('#areas option[value="0"]').attr('selected', 'selected').parent().focus();
        // $('#areas option[value="0"]').attr('selected', 'selected').parent().focus();


    }
)
function AreaHabit(){
    var id;
    var area;
    var habit;
    this.add = function () {
        $.ajax({
            url: "create/area-habit",
            data: {idArea:currentArea.id, idHabit:currentHabit.id},
            method:"GET",
            success:function (dataAreaHabit) {
                this.id=dataAreaHabit.id;
                this.area=dataAreaHabit.area;
                this.habit=dataAreaHabit.habit;
                tableAreaHabit.addRow(dataAreaHabit);
            }})

    }

    this.delete = function () {
        $.ajax({
            url: "delete/area-habit",
            data: JSON.stringify(this),
            method:"POST",
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            success:function () {
                this.id=null;
                this.area=null;
                this.habit=null;
                tableAreaHabit.deleteRow();
            }})
    }

    this.update = function () {
        $.ajax({
            url: "update/area-habit",
            data: JSON.stringify(this),
            method:"POST",
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            success:function (dataAreaHabit) {
                this.id=dataAreaHabit.id;
                this.area=dataAreaHabit.area;
                this.habit=dataAreaHabit.habit;
                tableAreaHabit.updateRow(this);
            }})
    }
}
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
                    tableAreaHabit.addRow(dataHabit);
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
                tableAreaHabit.deleteRow();
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
                tableAreaHabit.updateRow(this);
            }})
    }
}
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
function TableAreaHabit() {
    var table = $('#dataTable').DataTable({
            ajax: {
                url: "search-all/area-habit",
                dataSrc: ""
            },
            aoColumns: [
                { mData: "id" },
                { mData: "area.id" },
                { mData: "area.name" },
                { mData: "habit.id" },
                { mData: "habit.name" }
            ],
        columnDefs: [
            {
                className: "hide_object",
                "targets": [ 1,3 ]
            }
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
    currentAreaHabit = new AreaHabit();
    currentAreaHabit.id = rowData.id;

    $("#areas option:contains('"+rowData.area.name+"')").prop('selected', true);
    $('#areas').change();
    $("#habits option:contains('"+rowData.habit.name+"')").prop('selected', true);
    $('#habits').change();

    $("#showEventAdd").hide();
    $("#del").show();
    $("#upd").show();
    $("#add").hide();
    $("#edit_div").show();

}
function onRowDeselect(){
    currentArea = null;
    currentHabit = null;
    currentAreaHabit=null;
    $("#add").show();
    $("#edit_div").hide();
    $("#showEventAdd").show();
    clearEditArea();
}
function clearEditArea() {
}

function AllAreas() {
    var allAreas=[];
    this.load = function () {
        $.ajax({
            url: "search-all/area",
            data: {},
            method:"GET",
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            success:function (dataAreas) {
                for(var i = 0; i<dataAreas.length; i++)
                {
                    var area = new Area();
                    area.id = dataAreas[i].id;
                    area.name = dataAreas[i].name;
                    allAreas.push(area);
                }
                fillSelectAreas(allAreas);
            }})
    }
}
function fillSelectAreas(allAreas) {
    for(var i = 0; i< allAreas.length; i++)
    {
        var area = allAreas[i];
        $('#areas').append('<option value="' + area.id + '">' + area.name + '</option>')
    }
    //$('#areas option:eq(1)').prop('selected',true);
    $('#areas').change();
}
function AllHabits() {
    var allHabits=[];
    this.load = function () {
        $.ajax({
            url: "search-all/habit",
            data: {},
            method:"GET",
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            success:function (dataHabits) {
                for(var i = 0; i<dataHabits.length; i++)
                {
                    var habit = new Habit();
                    habit.id = dataHabits[i].id;
                    habit.name = dataHabits[i].name;
                    allHabits.push(habit);
                }
                fillSelectHabits(allHabits);
            }})
    }
}
function fillSelectHabits(allHabits) {
    for(var i = 0; i< allHabits.length; i++)
    {
        var habit = allHabits[i];
        $('#habits').append('<option value="' + habit.id + '">' + habit.name + '</option>')
    }
    //$('#habits option:eq(1)').prop('selected',true);
    $( "#habits" ).change();
}
