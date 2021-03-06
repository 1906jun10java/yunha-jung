(function() {
    document.getElementById("login-btn").addEventListener("click", evt => {
        evt.preventDefault();
    const username = document.getElementById("login").value;
    const password = document.getElementById("password").value;
    //alert(username);

    //need to convert js to JSON string then use AJAX xmlhttprequest to send data
    const loginObj = {
        "username": username,
        "password": password
    };

    //const jsonObj = JSON.stringify(loginObj);

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            //console.log(xhttp.responseText);
            let data = xhttp.responseText;
            let jsonResponse = JSON.parse(data);
            console.log(jsonResponse);
            // Checks if user is an Employee or not.
            //If user employee == true move to employeescreen.
            //If user employee == false move to ManagerScreen.
            if (jsonResponse.userExist == false){
                let invalid = document.getElementById("display-wrong");
                invalid.innerText = "Invalid Username or Password";
            } else {
                if(jsonResponse.employee == true) {
                    document.cookie = "user_id =" + jsonResponse.userId;
                    console.log(getCookie("user_id"));
                    //alert(getCookie("user_id"));
                    location.href = "EmployeeMain.html"
                } else if (jsonResponse.employee == false) {
                    document.cookie = "user_id =" + jsonResponse.userId;
                    console.log(getCookie("user_id"));
                    //alert(getCookie("user_id"));
                    location.href = "HomeScreenManager.html"
                }
            }
        }

    };

    //when tomcat is connected get the change the url
    xhttp.open("POST", "http://localhost:8080/Project11_war/login", true);
    xhttp.setRequestHeader("Content-type","application/json");
    xhttp.send(JSON.stringify(loginObj));
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
})();
