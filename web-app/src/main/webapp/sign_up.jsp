<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/entrance.css" type="text/css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/progressbar.js/1.0.1/progressbar.min.js"></script>
    <script rel="script" type="text/javascript" src="js/Entrance.js"></script>
    <title>Регистрация</title>
</head>
<body>
<div id="status-bar-container" hidden></div>
<div class="form-wrap">
    <div class="profile"><img src="fonts/minimal-poster-design-avatar.png" alt="Minimal poster design avatar">
        <h1>Регистрация</h1>
    </div>
    <form>
        <p>
        <div>
            <label for="nickname">Имя или псевдоним</label>
            <input id="nickname" type="text" required>
        </div>
        <p>
        <div>
            <label for="login">Электронная почта</label>
            <input id="login" type="text" required>
        </div>
        <p>
        <div>
            <label for="password">Пароль</label>
            <input id="password" type="password" required>
        </div>
        <button onclick="Entrance.signUp('nickname', 'login', 'password')">Сохранить</button>
        <p align="center"><a href="sign_in.jsp">Назад</a>
        </p>
    </form>
</div>
</body>
</html>