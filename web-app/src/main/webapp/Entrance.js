class Entrance {

    static submitValues(elements, form) {
        if (Entrance.isCorrect(elements)) {
            document.getElementById(form).method = "POST";
            document.getElementById(form).action = "calculator/sign_in";
        }
    }

    static isCorrect(elements) {
        for (let i = 0; i < elements.length; i++) {
            let isEmpty = document.getElementById(elements[i]).value.trim() === "";
            if (isEmpty) {
                alert("Needed correct value!");
                return false;
            }
        }
        return true;
    }

    static followTo(link) {
        document.location.href = link;
    }
}