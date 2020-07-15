<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>ИС Университет</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
</head>
<body>
<div class="loginContent">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-5">
                <form action="/registration" method="post" >
                    <div class="form-group">
                        <label for="username">Имя пользователя</label>
                        <input type="text" name="username" class="form-control">
                        <small id="emailHelp" class="form-text text-muted">Введите имя пользователя с помощью которого будет осуствляться вход в приложение</small>
                    </div>
                    <div class="form-group">
                        <label for="email">Электронная почта</label>
                        <input type="email" name="email" class="form-control"  placeholder="name@example.com">
                    </div>
                    <div class="form-group">
                        <label for="password">Пароль</label>
                        <input type="password" name="password" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="surname">Фамилия</label>
                        <input type="text" name="surname" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="firstname">Имя</label>
                        <input type="text" name="firstname" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="patronymic">Отчество</label>
                        <input type="text" name="patronymic" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="age">Возраст</label>
                        <input type="number" name="age" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="degree">Ученая степень</label>
                        <select name="degree" class="form-control">
                            <option value="Преподаватель">Преподаватель</option>
                            <option value="Старший преподаватель">Старший преподаватель</option>
                            <option value="Доцент">Доцент</option>
                            <option value="Кандидат наук">Кандидат наук</option>
                            <option value="Доктор наук">Доктор наук</option>
                            <option value="Профессор">Профессор</option>
                        </select>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-primary">Регистрация</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>
</html>


