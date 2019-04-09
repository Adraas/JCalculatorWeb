<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <script rel="script" type="text/javascript" src="Calculator.js"></script>
    <title>Калькулятор</title>
</head>
<body>
<form name="calc" class="wrapper">
    <table class="main">
        <tr class="display">
            <td colspan="4"><label>
                <input id="display" type="text" name="input">
            </label></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="1" onclick="Calculator.postRequestToCalculator('1')"></td>
            <td><input type="button" value="2" onclick="Calculator.postRequestToCalculator('2')"></td>
            <td><input type="button" value="3" onclick="Calculator.postRequestToCalculator('3')"></td>
            <td><input type="button" value="+" onclick="Calculator.postRequestToCalculator('+')"></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="4" onclick="Calculator.postRequestToCalculator('4')"></td>
            <td><input type="button" value="5" onclick="Calculator.postRequestToCalculator('5')"></td>
            <td><input type="button" value="6" onclick="Calculator.postRequestToCalculator('6')"></td>
            <td><input type="button" value="-" onclick="Calculator.postRequestToCalculator('-')"></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="7" onclick="Calculator.postRequestToCalculator('7')"></td>
            <td><input type="button" value="8" onclick="Calculator.postRequestToCalculator('8')"></td>
            <td><input type="button" value="9" onclick="Calculator.postRequestToCalculator('9')"></td>
            <td><input type="button" value="*" onclick="Calculator.postRequestToCalculator('*')"></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="." onclick="Calculator.postRequestToCalculator('.')"></td>
            <td><input type="button" value="0" onclick="Calculator.postRequestToCalculator('0')"></td>
            <td><input type="button" value="√" onclick="Calculator.postRequestToCalculator('√')"></td>
            <td><input type="button" value="/" onclick="Calculator.postRequestToCalculator('/')"></td>
        </tr>
        <tr class="buttons">
            <td><input type="reset" value="AC" onclick="Calculator.postRequestToCalculator('C')"></td>
            <td><input type="button" value="=" onclick="Calculator.postRequestToCalculator('=')"></td>
            <td><input type="button" value="^" onclick="Calculator.postRequestToCalculator('^')"></td>
        </tr>
    </table>
</form>
<p><a href='sign_in.jsp'>Выход</a></p>
</body>
</html>