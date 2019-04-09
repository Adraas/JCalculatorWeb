class Calculator {

    static postRequestToCalculator(symbol) {
        let data = "symbol=" + symbol;
        let xmlHttp = new XMLHttpRequest();

        xmlHttp.open("POST", "/calculator/profile.jsp", true);
        xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
        xmlHttp.send(data);

        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState === XMLHttpRequest.DONE) {
                if (xmlHttp.status === 200) {
                    let response = xmlHttp.responseText;
                    if (isNaN(response)) {
                        alert(response);
                        document.getElementById("display").value = "";
                    } else {
                        document.getElementById("display").value = xmlHttp.responseText;
                    }
                } else {
                    alert(String(xmlHttp.status).concat(": ", xmlHttp.statusText));
                }
            }
        };
    }
}