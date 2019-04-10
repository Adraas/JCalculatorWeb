<html>
<head>
    <meta charset="UTF-8">
    <script rel="script" type="text/javascript" src="js/Entrance.js"></script>
    <title>Регистрация</title>
</head>
<body>
<div style="text-align: center;">
    <form name="sign_up_form">
        <p><input id="full_name" name="full_name" placeholder="ФИО" size="40" type="text"></p>
        <p><input id="login" name="login" placeholder="Логин" size="40" type="text"></p>
        <p><input id="password" name="password" placeholder="Пароль" size="40" type="password"></p>
        <p><input name="sign_up" type="button" value="Регистрация"
                  onclick="Entrance.signUp('full_name', 'login', 'password')">
        </p>
    </form>
</div>
<p><a href='sign_in.jsp'>Назад</a></p>
</body>
</html>