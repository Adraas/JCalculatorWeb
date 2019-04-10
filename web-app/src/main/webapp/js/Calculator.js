class Calculator {

    static postRequestToCalculator(symbol) {
        let data = "symbol=" + symbol;
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
}