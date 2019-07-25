function newElement(firstName,lastName,content, amount, created, status) {
    let table = document.getElementById("myTable");


    let row = table.insertRow(1);
    let cell1 = row.insertCell(0);
    let cell2 = row.insertCell(1);
    let cell3 = row.insertCell(2);
    let cell4 = row.insertCell(3);
    let cell5 = row.insertCell(4);


    cell1.innerHTML =  firstName + " " + lastName;
    cell2.innerHTML = "$" + amount;
    cell3.innerHTML = content;
    cell4.innerHTML = created;
    cell5.innerHTML = status;
}


function getJsonData() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/Project11_war/AllReimbursementAsManager",
        contentType: "application/json",
        dataType: "json",

        success: function(data) {
            var obj1 = JSON.stringify(data.allReimbursements);
            var obj = JSON.parse(obj1);
            for (k = 0; k < obj.length; k++) {
                newElement(obj[k].firstName,obj[k].lastName,obj[k].theContents,obj[k].amount,obj[k].created ,obj[k].status);
            }
        },
        error: function(data) {
            alert('fail');
        }
    });
}
getJsonData();
