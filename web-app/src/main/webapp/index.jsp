<html>
<head>
    <meta charset="UTF-8">
    <title>Вход</title>
</head>
<body>
<div style="text-align: center;">
    <form name="sign_in_form" method="post" action="SignInServlet">
        <p>Войти или <a href="sign_up.jsp">зарегистрироваться</a></p>
        <p><input name="login" placeholder="Логин" size="40" type="text"></p>
        <p><input name="password" placeholder="Пароль" size="40" type="password"></p>
        <p><input name="sign_in" type="submit" value="Вход"></p>
    </form>
</div>
</body>
</html>
