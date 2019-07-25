function newElement(id,firstName,lastName,content, amount, created, status) {
    let table = document.getElementById("myTable");

    let row = table.insertRow(1);
    let cell1 = row.insertCell(0);
    let cell2 = row.insertCell(1);
    let cell3 = row.insertCell(2);
    let cell4 = row.insertCell(3);
    let cell5 = row.insertCell(4);
    let cell6 = row.insertCell(5);


    cell1.innerHTML =  firstName + " " + lastName;
    cell2.innerHTML = "$" + amount;
    cell3.innerHTML = content;
    cell4.innerHTML = created;
    cell5.innerHTML = status;
    cell6.innerHTML = "<button " +"onclick = 'setApproved("+ id +",this)'"+">Approve</button><button " +"onclick = 'setDenied("+ id +",this)'"+">Deny</button>";

}
function getJsonData() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/Project11_war/PendingReimbursementAsManager",
        contentType: "application/json",
        dataType: "json",

        success: function(data) {
            var obj1 = JSON.stringify(data.reimbursements);
            var obj = JSON.parse(obj1);
            for (k = 0; k < obj.length; k++) {
                newElement(obj[k].reimbursementID,obj[k].firstName,obj[k].lastName,obj[k].theContents,obj[k].amount,obj[k].created,obj[k].status);
            }
        },
        error: function(data) {
            alert('fail');
        }
    });
}

function setApproved(id,element) {
    document.getElementById("myTable").deleteRow(element.parentNode.parentNode.rowIndex);


    $.ajax({
        type: "GET",
        url: "http://localhost:8080/Project11_war/PendingReimbursementAsManager",
        data: {status: '2', theId: id},
        contentType: "application/json",
        dataType: "json",

        success: function (data) {

        },
        error: function (data) {
            alert('fail');
        }
    });


}

function setDenied(id,element) {
    document.getElementById("myTable").deleteRow(element.parentNode.parentNode.rowIndex);

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/Project11_war/PendingReimbursementAsManager",
        data: {status: '3', theId: id},
        contentType: "application/json",
        dataType: "json",

        success: function (data) {

        },
        error: function (data) {
            alert('fail');
        }
    });


}

getJsonData();
