<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Sweater</title>
</head>
<body>
<h3><a href="/student">Выйти</a></h3>
<div style="width: 215px; border: black solid 2px; padding: 3px">
    <h3>Карточка студента</h3>
    <form action="/student/#{student.id}" method="post">
        <div><input type="text" name="surname" value="${student.surname}" required placeholder="Фамилия" ></div>
        <div><input type="text" name="firstname" value="" required placeholder="Имя"></div>
        <div><input type="text" name="patronymic" value="" required placeholder="Отчество"></div>
        <div><input type="number" name="age" value="" required placeholder="Возраст"></div>
        <button type="Изменить">Изменить</button>
    </form>
</div>
</body>
</html>