<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <script rel="script" type="text/javascript" src="Calculator.js"></script>
    <title>Калькулятор</title>
</head>
<body>
<form name="calc" class="wrapper" method="post" action="CalculatorServlet">
    <table class="main">
        <tr class="display">
            <td colspan="4"><label>
                <input type="text" name="input">
            </label></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="1"></td>
            <td><input type="button" value="2"></td>
            <td><input type="button" value="3"></td>
            <td><input type="button" value="+"></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="4"></td>
            <td><input type="button" value="5"></td>
            <td><input type="button" value="6"></td>
            <td><input type="button" value="-"></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="7"></td>
            <td><input type="button" value="8"></td>
            <td><input type="button" value="9"></td>
            <td><input type="button" value="*"></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="."></td>
            <td><input type="button" value="0"></td>
            <td><input type="button" value="√"></td>
            <td><input type="button" value="/"></td>
        </tr>
        <tr class="buttons">
            <td><input type="reset" value="AC"></td>
            <td><input type="button" value="="></td>
            <td><input type="button" value="^"></td>
        </tr>
    </table>
</form>
<p><a href='index.jsp'>Отмена</a></p>
</body>
</html>