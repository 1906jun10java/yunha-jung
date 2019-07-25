(function() {
    let user_id = getCookie("user_id");

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            let arr = JSON.parse(xhttp.responseText);

            for(let i = arr.reimbursements.length-1; i >= 0 ; i--) {
                newElement(arr.reimbursements[i].content, arr.reimbursements[i].amount, arr.reimbursements[i].created, arr.reimbursements[i].status);
            }
        }
    };
    //when tomcat is connected get the change the url
    xhttp.open("GET", "http://localhost:8080/Project11_war/submitform/?user_id=" + user_id + "&status=pending", true);
    xhttp.setRequestHeader("Content-type","application/json");
    xhttp.send();
    console.log(JSON.stringify("http://localhost:8080/Project11_war/submitform/?user_id" + user_id));

})();

document.getElementById("delete-cookies").addEventListener('click', evt=> {
    let user_id = getCookie("user_id");
    console.log(user_id);
    document.cookie.split(";").forEach(function(c) { document.cookie = c.replace(/^ +/, "").replace(/=.*/, "=;expires=" + new Date().toUTCString() + ";path=/"); });
    console.log(user_id);
})


function newElement(content, amount, created, status) {
    let table = document.getElementById("myTable");
    let row = table.insertRow(1);
    let cell1 = row.insertCell(0);
    let cell2 = row.insertCell(1);
    let cell3 = row.insertCell(2);
    let cell4 = row.insertCell(3);

    cell1.innerHTML = "$ " + amount;
    cell2.innerHTML = content;
    cell3.innerHTML = created;
    cell4.innerHTML = status;
}

function getCookie(cname) {
    let name = cname + "=";
    let ca = document.cookie.split(';');
    for(let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}



