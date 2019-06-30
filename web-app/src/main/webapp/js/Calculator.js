class Calculator {

    static roundingAccuracy = 1;

    static setRange(roundingAccuracyElement) {
        Calculator.roundingAccuracy = document.getElementById(roundingAccuracyElement).value;
    }

    static postRequestToCalculator(symbol) {
        let userCookie = Calculator.readCookie("name");
        let roundingAccuracy = Calculator.roundingAccuracy;
        let data = "cookie=" + userCookie + "&rounding_accuracy" + roundingAccuracy + "&symbol=" + symbol;
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.onload = function () {
            let status = xmlHttp.status;
            if (status >= 400) {
                let statusText = xmlHttp.statusText;
                if (statusText != null && statusText.trim() !== "") {
                    window.open("", "Error").document.writeln(statusText);
                } else {
                    window.open("", "Error").document.writeln("Status code: " + String(status));
                }
            } else {
                let response = xmlHttp.responseText;
                if (response.trim() !== "") {
                    if (isNaN(response)) {
                        alert(response);
                        document.getElementById("display").value = "";
                    } else {
                        document.getElementById("display").value = response;
                    }
                }
            }
        };
        xmlHttp.open("POST", "/secured/calculator", true);
        xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        xmlHttp.send(data);
    }

    static readCookie(name) {
        let name_cookie = name + "=";
        let spl = document.cookie.split(";");
        for (let i = 0; i < spl.length; i++) {
            let c = spl[i];
            while (c.charAt(0) === " ") {
                c = c.substring(1, c.length);
            }
            if (c.indexOf(name_cookie) === 0) {
                return c.substring(name_cookie.length, c.length);
            }
        }
        return null;
    }
}