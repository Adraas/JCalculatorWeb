<html>
<head>
    <meta charset="UTF-8">
    <script rel="script" type="text/javascript" src="js/Entrance.js"></script>
    <title>Авторизация</title>
</head>
<body>
<div style="text-align: center;">
    <form name="sign_in_form">
        <p>Войти или <a href="sign_up.jsp">зарегистрироваться</a></p>
        <p><input id="login" name="login" placeholder="Логин" size="40" type="text"></p>
        <p><input id="password" name="password" placeholder="Пароль" size="40" type="password"></p>
        <p><input name="sign_in" type="button" value="Вход"
                  onclick="Entrance.submitValues('login', 'password', 'calculator/sign_in')">
        </p>
    </form>
</div>
</body>
</html>
