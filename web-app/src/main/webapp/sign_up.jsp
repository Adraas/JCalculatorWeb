<html>
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
</head>
<body>
<div style="text-align: center;">
    <form name="sign_up_form" method="post" action="SignUpServlet">
        <p><input name="full_name" placeholder="ФИО" size="40" type="text"></p>
        <p><input name="login" placeholder="Логин" size="40" type="text"></p>
        <p><input name="password" placeholder="Пароль" size="40" type="password"></p>
        <p><input name="sign_up" type="submit" value="Регистрация"></p>
    </form>
</div>
<p><a href='index.jsp'>Отмена</a></p>
</body>
</html>
