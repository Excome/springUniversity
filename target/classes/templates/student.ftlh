<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Sweater</title>
</head>
<body>
<h1>Hello student!</h1>
<a href="/">Главная</a>
<div>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Возвраст</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list students as student>
            <tr>
                <td>${student.surname}</td>
                <td>${student.firstname}</td>
                <td>${student.patronymic}</td>
                <td>${student.age}</td>
                <td><a href="/student/${student.id}">edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<div style="width: 215px; border: black solid 2px; padding: 3px">
    <h3>Добавить студента</h3>
    <form action="/student" method="post">
        <div><input type="text" name="surname" required placeholder="Фамилия" ></div>
        <div><input type="text" name="firstname" required placeholder="Имя"></div>
        <div><input type="text" name="patronymic" required placeholder="Отчество"></div>
        <div><input type="number" name="age" required placeholder="Возраст"></div>
        <button type="submit">Добавить</button>
    </form>
</div>
<div style="width: 215px; border: black solid 2px; padding: 3px">
    <h3>Удалить студента</h3>
    <form action="/student/delete" method="post">
        <div><input type="number" name="studentId" placeholder="Введите Id"></div>
        <button type="submit">Удалить</button>
    </form>
</div>
</body>
</html>