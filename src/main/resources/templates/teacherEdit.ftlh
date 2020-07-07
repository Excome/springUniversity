<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container">
        <h3>Карточка учителя</h3>
        <form action="/teacher/update" method="post">
            <div class="form-group">
                <label for="surname">Фамилия</label>
                <input class="form-control" type="text" name="surname" value="${teacher.surname}" required>
            </div>
            <div class="form-group">
                <label for="firstname">Имя</label>
                <input class="form-control" type="text" name="firstname" value="${teacher.firstname}" required>
            </div>
            <div class="form-group">
                <label for="patronymic">Отчество</label>
                <input class="form-control" type="text" name="patronymic" value="${teacher.patronymic}" required>
            </div>
            <div class="form-group">
                <label for="age">Возраст</label>
                <input class="form-control" type="number" name="age" value="${teacher.age}" required>
            </div>
            <div class="form-group">
                <label for="teacherDegrees">Ученая степень</label>
                <select name="degree" class="form-control" id="exampleFormControlSelect1" >
                    <option value="">тест</option>
                </select>
            </div>
            <input type="hidden" name="teacherId" value="${teacher.id}">
            <button type="submit" class="btn btn-primary" style="float: left">Изменить</button>
        </form>
        <form action="/teacher/delete" method="post">
            <input type="hidden" name="teacherId" value="${teacher.id}">
            <button type="submit" class="deleteBtn btn btn-primary ml-2">Удалить</button>
        </form>
    </div>
</@c.page>