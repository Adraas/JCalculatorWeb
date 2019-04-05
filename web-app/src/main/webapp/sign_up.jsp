<html>
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <script rel="script" type="text/javascript" src="Entrance.js"></script>
</head>
<body>
<div style="text-align: center;">
    <form id="sign_up_form" name="sign_up_form">
        <p><input name="full_name" placeholder="ФИО" size="40" type="text"></p>
        <p><input id="login" name="login" placeholder="Логин" size="40" type="text"></p>
        <p><input id="password" name="password" placeholder="Пароль" size="40" type="password"></p>
        <p><input name="sign_up" type="submit" value="Регистрация"
                  onclick="Entrance.submitValues(['login', 'password'], 'sign_in_form', 'post', 'SignUpServlet')"></p>
    </form>
</div>
<p><a href='index.jsp'>Отмена</a></p>
</body>
</html>
