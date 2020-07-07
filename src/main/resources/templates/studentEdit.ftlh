<#import "parts/common.ftlh" as c>
<@c.page>
<div class="container">
    <h3>Карточка студента</h3>
    <form action="/student/update" method="post">
        <div class="form-group">
            <label for="surname">Фамилия</label>
            <input class="form-control" type="text" name="surname" value="${student.surname}" required>
        </div>
        <div class="form-group">
            <label for="firstname">Имя</label>
            <input class="form-control" type="text" name="firstname" value="${student.firstname}" required>
            </div>
        <div class="form-group">
            <label for="patronymic">Отчество</label>
            <input class="form-control" type="text" name="patronymic" value="${student.patronymic}" required>
        </div>
        <div class="form-group">
            <label for="age">Возраст</label>
            <input class="form-control" type="number" name="age" value="${student.age}" required>
        </div>
        <div class="form-group">
            <label for="exampleFormControlSelect1">Группа</label>
            <select name="groupStudId" class="form-control" id="exampleFormControlSelect1" >
                <#list groups as group>
                    <option value="${group.id}">${group.faculty}: ${group.name}</option>
                </#list>
            </select>
        </div>
        <input type="hidden" name="studentId" value="${student.id}">
        <button type="submit" class="btn btn-primary" style="float: left">Изменить</button>
    </form>
    <form action="/student/delete" method="post">
        <input type="hidden" name="studentId" value="${student.id}">
        <button type="submit" class="deleteBtn btn btn-primary ml-2">Удалить</button>
    </form>
</div>
</@c.page>
