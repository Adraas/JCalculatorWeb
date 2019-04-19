class Entrance {

    static signIn(loginElement, passwordElement) {
        if (this.isCorrect([loginElement, passwordElement])) {
            let login = document.getElementById(loginElement);
            let password = document.getElementById(passwordElement);
            let data = "login=" + login + "&password=" + password;
            this.doRequest(data,"/calculator/sign_in");
        } else {
            alert("Проверьте данные!")
        }
    }

    static signUp(fullNameElement, loginElement, passwordElement) {
        if (this.isCorrect([loginElement, passwordElement])) {
            let fullName = document.getElementById(fullNameElement);
            let login = document.getElementById(loginElement);
            let password = document.getElementById(passwordElement);
            let data = "fullName=" + fullName + "&login=" + login + "&password=" + password;
            this.doRequest(data,"/calculator/sign_up");
        } else {
            alert("Проверьте данные!")
        }
    }

    static doRequest(data, URL) {
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.open("POST", URL, true);
        xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
        xmlHttp.send(data);

        xmlHttp.onload = function () {
            let result = xmlHttp.getResponseHeader("result");
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