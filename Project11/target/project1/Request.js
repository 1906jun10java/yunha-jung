(function() {
    document.getElementById("request-btn").addEventListener("click", evt => {
        // evt.preventDefault();
        const amount = document.getElementById("amount").value;
        const created = document.getElementById("created").value;
        const description = document.getElementById("description").value;

        if (!($('#requestReim')[0].checkValidity())) {
            return false;
        } else {
            let user_id = getCookie("user_id");
            //need to convert js to JSON string then use AJAX xmlhttprequest to send data
            const requestObj = {
                "user_id": user_id,
                "amount": amount,
                "created": created,
                "description": description
            };

            let xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    window.location.reload();
                }
            };
            //when tomcat is connected get the change the url
            xhttp.open("POST", "http://localhost:8080/Project11_war/submitform", true);
            xhttp.setRequestHeader("Content-type","application/json");
            xhttp.send(JSON.stringify(requestObj));
            console.log(JSON.stringify(requestObj));
        }
    })

})();

document.getElementById("delete-cookies").addEventListener('click', evt=> {
    let user_id = getCookie("user_id");
    console.log(user_id);
    document.cookie.split(";").forEach(function(c) { document.cookie = c.replace(/^ +/, "").replace(/=.*/, "=;expires=" + new Date().toUTCString() + ";path=/"); });
    console.log(user_id);
})

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