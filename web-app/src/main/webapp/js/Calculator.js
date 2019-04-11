class Calculator {

    static expression : String;
    static roundingAccuracy = 1;

    static setRange(roundingAccuracyElement) {
        this.roundingAccuracy = document.getElementById(roundingAccuracyElement).value;
    }

    static checkAndSend(symbol) {
    }

    static postRequestToCalculator() {
        let userCookie = this.readCookie("name");
        let roundingAccuracy = this.roundingAccuracy;
        let data = "cookie=" + userCookie + "&rounding_accuracy" + roundingAccuracy + "&expression=" + this.expression;
        let xmlHttp = new XMLHttpRequest();

        xmlHttp.open("POST", "calculator/profile", true);
        xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
        xmlHttp.send(data);

        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState === XMLHttpRequest.DONE) {
                let status = xmlHttp.status;
                if (status >= 200 && status < 300) {
                    let response = xmlHttp.responseText;
                    if (isNaN(response)) {
                        alert(response);
                        document.getElementById("display").value = "";
                    } else {
                        document.getElementById("display").value = response;
                    }
                } else {
                    alert(String(status).concat(": ", xmlHttp.statusText));
                }
            }
        };
    }

    static readCookie(name) {
        let name_cook = name + "=";
        let spl = document.cookie.split(";");
        for (let i = 0; i < spl.length; i++) {
            let c = spl[i];
            while (c.charAt(0) === " ") {
                c = c.substring(1, c.length);
            }
            if (c.indexOf(name_cook) === 0) {
                return c.substring(name_cook.length, c.length);
            }
        }
        return null;
    }
}