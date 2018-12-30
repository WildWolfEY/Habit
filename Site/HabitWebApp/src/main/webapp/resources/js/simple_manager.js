$(document).ready(
    function(){
        autoLoad();
    }
)

function autoLoad()
{
    var tbl = $('#dataTable').DataTable({
        ajax: {
            url: "search-all/user",
            dataSrc: ""
        },
        aoColumns: [
                { mData: "id" },
                { mData: "login" }
            ]
        //autofill: true,
        //"select": true
        //responsive: true,
        //buttons: true
        //length: 12
    });
}

function load_data()
{
    $.ajax({
        type: "GET",
        url:"search-all/user",
        success:function(data){
            for(var i=0; i<data.length; i++)
            {
                var user = new User();
                user.nom = data[i].id;
                user.name = data[i].login;
                users.push(user);
                alert(user);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("Status: " + textStatus+";  Error: " + errorThrown);
        }
    })
}
function User()
{
    var id;
    var name;
}
var users = [];
function fill_dataTable()
{
    var tbl = $("#dataTable").DataTable();
    for(var i=0; i<users.length; i++)
    {
        tbl.row.add(users[i]).draw( false );
    }
}