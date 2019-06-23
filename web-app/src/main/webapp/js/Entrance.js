class Entrance {

    static signIn(loginElement, passwordElement) {
        if (this.isCorrect([loginElement, passwordElement])) {
            let login = document.getElementById(loginElement);
            let password = document.getElementById(passwordElement);
            let data = "Basic " + btoa(login.value + ", " + password.value);
            Entrance.doRequest(data, "Authorization", "sign_in", "GET");
        } else {
            alert("Проверьте данные!")
        }
    }

    static signUp(nicknameElement, loginElement, passwordElement) {
        if (this.isCorrect([loginElement, passwordElement])) {
            let nickname = document.getElementById(nicknameElement);
            let login = document.getElementById(loginElement);
            let password = document.getElementById(passwordElement);
            let data = "nickname=" + nickname.value + "&login=" + login.value + "&password=" + password.value;
            Entrance.doRequest(data, null, "sign_up", "POST");
        } else {
            alert("Проверьте данные!")
        }
    }

    static doRequest(data, header, URL, requestType) {
        let xmlHttp = new XMLHttpRequest();
        let xmlHttpUpload = xmlHttp.upload;
        xmlHttpUpload.onprogress = function () {
            let statusBarContainer = document.querySelector("#status-bar-container");
            let bar = new ProgressBar.Circle(statusBarContainer, {
                strokeWidth: 6,
                easing: 'easeInOut',
                duration: 20000,
                color: '#FFEA82',
                trailColor: '#eee',
                trailWidth: 1
            });
            statusBarContainer.style.visibility = 'visible';
            bar.animate(1);
        };
        xmlHttp.onload = function () {
            let response = xmlHttp.responseText;
            if (response.trim() !== "") {
                if (!response.startsWith("<!")) {
                    alert(response);
                } else {
                    window.document.writeln(response);
                }
            }
        };
        xmlHttp.open(requestType, URL, false);
        xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        if (header == null) {
            xmlHttp.send(data);
        } else {
            xmlHttp.setRequestHeader(header, data);
            xmlHttp.send();
        }
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