function getJsonData() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/Project11_war/AllEmployees",
        contentType: "application/json",
        dataType: "json",

        success: function (data) {

            var obj1 = JSON.stringify(data.allEmployees);
            var obj = JSON.parse(obj1);
            for (k = 0; k < obj.length; k++) {
                newElement(obj[k].id,obj[k].firstName,obj[k].lastName,obj[k].email);
            }
        },
        error: function (data) {
            alert('fail');
        }
    });
}

function newElement(id,firstName,lastName,email) {
    let table = document.getElementById("myTable");

    let row = table.insertRow(1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);



    cell1.innerHTML =  id;
    cell2.innerHTML = firstName + " " + lastName;
    cell3.innerHTML = email;
    cell4.innerHTML = "<button " +"onclick = 'getTheReimData("+ id +")'"+">View Reimbursements</button>";

}
function newElement2(firstName,lastName,content, amount, created, status) {
    let table = document.getElementById("myTable2");


    let row = table.insertRow(1);
    let cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);


    cell1.innerHTML =  firstName + " " + lastName;
    cell2.innerHTML = "$" + amount;
    cell3.innerHTML = content;
    cell4.innerHTML = created;
    cell5.innerHTML = status;

}
function getTheReimData(id) {
    var table = document.getElementById("myTable2");
//or use :  var table = document.all.tableid;
    for(var i = table.rows.length - 1; i > 0; i--)
    {
        table.deleteRow(i);
    }
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/Project11_war/AllEmployees",
        data: {theId: id},
        contentType: "application/json",
        dataType: "json",

        success: function(data) {
            var obj1 = JSON.stringify(data.employeeReimbursements);
            var obj = JSON.parse(obj1);
            for (k = 0; k < obj.length; k++) {
                newElement2(obj[k].firstName,obj[k].lastName,obj[k].theContents,obj[k].amount,obj[k].created,obj[k].status);
            }
        },
        error: function(data) {
            alert('fail');
        }
    });
}
getJsonData();
