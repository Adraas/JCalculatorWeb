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
            if (xmlHttp.status >= 400) {
                window.open().document.writeln(xmlHttp.statusText);
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
        xmlHttp.open("POST", "profile", true);
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