class Entrance {

    static submitValues(login, password, URL) {
        if (Entrance.isCorrect([login, password])) {
            let data = "login=" + login + "&password=" + password;
            let xmlHttp = new XMLHttpRequest();

            xmlHttp.open("POST", URL, true);
            xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
            xmlHttp.send(data);

            xmlHttp.onreadystatechange = function () {
                let status = xmlHttp.status;
                if (status >= 400) {
                    alert(String(status).concat(": ", xmlHttp.statusText));
                }
            };
        } else {
            alert("Needed correct value!");
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