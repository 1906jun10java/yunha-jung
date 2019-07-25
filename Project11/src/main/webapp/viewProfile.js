(function() {
    let user_id = getCookie("user_id");

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(xhttp.responseText);
            let userInfo = JSON.parse(xhttp.responseText);
            let username = document.getElementById("tdUsername");
            let email = document.getElementById("tdEmail");
            let firstname = document.getElementById("tdFirst");
            let lastname = document.getElementById("tdLast");

            username.innerHTML = userInfo.username;
            email.innerHTML = userInfo.email;
            firstname.innerHTML = userInfo.first_Name;
            lastname.innerHTML =userInfo.last_Name;
        }
    };
    //when tomcat is connected get the change the url
    xhttp.open("GET", "http://localhost:8080/Project11_war/login/?user_id=" + user_id, true);
    xhttp.setRequestHeader("Content-type","application/json");
    xhttp.send();
})();

let user_id = getCookie("user_id");

document.getElementById("email-update-btn").addEventListener('click', evt => {
    const newEmail = document.getElementById('updated-email').value;
    if (!($('#emailCheck')[0].checkValidity())) {
        return false;
    } else {
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                alert(xhttp.responseText);
                location.reload();
            }
        };
        xhttp.open("GET", "http://localhost:8080/Project11_war/updateinfo/?user_id=" + user_id + "&status=email&update=" + newEmail, true);
        xhttp.setRequestHeader("Content-type","application/json");
        xhttp.send();
    }
})

document.getElementById("first-update-btn").addEventListener('click', evt => {
    const newFirst = document.getElementById('updated-first').value;
    if (!($('#firstnameCheck')[0].checkValidity())) {
        return false;
    } else {
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                alert(xhttp.responseText);
                location.reload();
            }
        };
        xhttp.open("GET", "http://localhost:8080/Project11_war/updateinfo/?user_id=" + user_id + "&status=first&update=" + newFirst, true);
        xhttp.setRequestHeader("Content-type","application/json");
        xhttp.send();
    }
})

document.getElementById("last-update-btn").addEventListener('click', evt => {
    const newLast = document.getElementById('updated-last').value;
    if (!($('#lastnameCheck')[0].checkValidity())) {
        return false;
    } else {
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                alert(xhttp.responseText);
                location.reload();
            }
        };
        xhttp.open("GET", "http://localhost:8080/Project11_war/updateinfo/?user_id=" + user_id + "&status=last&update=" + newLast, true);
        xhttp.setRequestHeader("Content-type","application/json");
        xhttp.send();
    }
})

document.getElementById("delete-cookies").addEventListener('click', evt=> {
    document.cookie.split(";").forEach(function(c) { document.cookie = c.replace(/^ +/, "").replace(/=.*/, "=;expires=" + new Date().toUTCString() + ";path=/"); });
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





