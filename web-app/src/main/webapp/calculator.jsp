<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/calculator.css"/>
    <script rel="script" type="text/javascript" src="js/Calculator.js"></script>
    <title>Калькулятор</title>
</head>
<body>
<form class="wrapper">
    <table class="main">
        <tr class="display">
            <td colspan="4"><label>
                <input id="display" type="text">
            </label></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="1" onclick="Calculator.postRequestToCalculator('1', 'range')"></td>
            <td><input type="button" value="2" onclick="Calculator.postRequestToCalculator('2', 'range')"></td>
            <td><input type="button" value="3" onclick="Calculator.postRequestToCalculator('3', 'range')"></td>
            <td><input type="button" value="+" onclick="Calculator.postRequestToCalculator('+', 'range')"></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="4" onclick="Calculator.postRequestToCalculator('4', 'range')"></td>
            <td><input type="button" value="5" onclick="Calculator.postRequestToCalculator('5', 'range')"></td>
            <td><input type="button" value="6" onclick="Calculator.postRequestToCalculator('6', 'range')"></td>
            <td><input type="button" value="-" onclick="Calculator.postRequestToCalculator('-', 'range')"></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="7" onclick="Calculator.postRequestToCalculator('7', 'range')"></td>
            <td><input type="button" value="8" onclick="Calculator.postRequestToCalculator('8', 'range')"></td>
            <td><input type="button" value="9" onclick="Calculator.postRequestToCalculator('9', 'range')"></td>
            <td><input type="button" value="*" onclick="Calculator.postRequestToCalculator('*', 'range')"></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="." onclick="Calculator.postRequestToCalculator('.', 'range')"></td>
            <td><input type="button" value="0" onclick="Calculator.postRequestToCalculator('0', 'range')"></td>
            <td><input type="button" value="√" onclick="Calculator.postRequestToCalculator('√', 'range')"></td>
            <td><input type="button" value="/" onclick="Calculator.postRequestToCalculator('/', 'range')"></td>
        </tr>
        <tr class="buttons">
            <td><input type="reset" value="AC" onclick="Calculator.postRequestToCalculator('C', 'range')"></td>
            <td><input type="button" value="=" onclick="Calculator.postRequestToCalculator('=', 'range')"></td>
            <td><input type="button" value="^" onclick="Calculator.postRequestToCalculator('^', 'range')"></td>
            <td><input id="range" type="range" min="1" max="10" step="1" value="0"></td>
        </tr>
    </table>
    <p align="center"><a href='sign_in.jsp'>Выход</a></p>
</form>
</body>
</html>