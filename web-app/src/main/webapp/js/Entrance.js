class Entrance {

    static signIn(loginElement, passwordElement) {
        if (this.isCorrect([loginElement, passwordElement])) {
            let login = document.getElementById(loginElement);
            let password = document.getElementById(passwordElement);
            let data = btoa(login + ", " + password);
            this.doRequest(data, "Authorization", "/calculator/sign_in");
        } else {
            alert("Проверьте данные!")
        }
    }

    static signUp(fullNameElement, loginElement, passwordElement) {
        if (this.isCorrect([loginElement, passwordElement])) {
            let fullName = document.getElementById(fullNameElement);
            let login = document.getElementById(loginElement);
            let password = document.getElementById(passwordElement);
            let data = "full_name=" + fullName + "&login=" + login + "&password=" + password;
            this.doRequest(data, null, "/calculator/sign_up");
        } else {
            alert("Проверьте данные!")
        }
    }

    static doRequest(data, header, URL) {
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.open("POST", URL, true);
        xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
        if (header != null) {
            xmlHttp.setRequestHeader(header, data);
            xmlHttp.send();
        } else {
            xmlHttp.send(data);
        }

        xmlHttp.onload = function () {
            let result = xmlHttp.getResponseHeader("Result");
            if (result != null || result !== "") {
                alert(result);
            }
        };
    }

    static isCorrect(elements) {
        for (let i = 0; i < elements.length; i++) {
            let isEmpty = document.getElementById(elements[i]).value.trim() === "";
            if (isEmpty) {
                return false;
            }
        }
        return true;
    }
}