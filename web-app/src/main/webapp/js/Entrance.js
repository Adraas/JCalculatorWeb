class Entrance {

    static signIn(loginElement, passwordElement) {
        if (this.isCorrect([loginElement, passwordElement])) {
            let login = document.getElementById(loginElement);
            let password = document.getElementById(passwordElement);
            let data = "Basic " + btoa(login.value + ", " + password.value);
            Entrance.doRequest(data, "Authorization", "/calculator/sign_in", "POST");
        } else {
            alert("Проверьте данные!")
        }
    }

    static signUp(fullNameElement, loginElement, passwordElement) {
        if (this.isCorrect([loginElement, passwordElement])) {
            let fullName = document.getElementById(fullNameElement);
            let login = document.getElementById(loginElement);
            let password = document.getElementById(passwordElement);
            let data = "full_name=" + fullName.value + "&login=" + login.value + "&password=" + password.value;
            Entrance.doRequest(data, null, "/calculator/sign_up", "POST");
        } else {
            alert("Проверьте данные!")
        }
    }

    static doRequest(data, header, URL, requestType) {
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.open(requestType, URL, true);
        xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        if (header == null) {
            xmlHttp.send(data);
        } else {
            xmlHttp.setRequestHeader(header, data);
            xmlHttp.send();
        }

        xmlHttp.onload = function () {
            let result = xmlHttp.responseText;
            if (result != null && result !== "") {
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