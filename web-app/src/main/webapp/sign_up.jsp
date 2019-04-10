<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/entrance.css" type="text/css"/>
    <script rel="script" type="text/javascript" src="js/Entrance.js"></script>
    <title>Регистрация</title>
</head>
<body>
<div class="form-wrap">
    <div class="profile"><img src="fonts/profile-image.png">
        <h1>Регистрация</h1>
    </div>
    <form>
        <div>
            <label for="full_name">ФИО</label>
            <input id="full_name" type="text" required>
        </div>
        <div>
            <label for="login">Логин</label>
            <input id="login" type="text" required>
        </div>
        <div>
            <label for="password">Пароль</label>
            <input id="password" type="password" required>
        </div>
        <button onclick="Entrance.signUp('full_name', 'login', 'password')">Добавление</button>
        <p align="center"><a href="sign_in.jsp">Назад</a></p>
    </form>
</div>
</body>
</html>