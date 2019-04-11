class Calculator {

    static isNew = true;

    static postRequestToCalculator(symbol, roundingAccuracyElement) {
        let userCookie = this.readCookie("name");
        let isNew = String(this.isNew);
        this.isNew = false;
        let roundingAccuracy = document.getElementById(roundingAccuracyElement).value;
        let data = "cookie=" + userCookie + "&is_new=" + isNew
            + "&rounding_accuracy" + roundingAccuracy + "&symbol=" + symbol;
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