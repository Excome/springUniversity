<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="row">
        <div class="col-9">
            <table class="table" style="text-align: center">
                <thead class="thead-dark">
                <tr>
                    <th>Фамилия</th>
                    <th>Имя</th>
                    <th>Отчество</th>
                    <th>Возвраст</th>
                    <th>Группа</th>
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
                        <td>${student.groupName}</td>
                        <td><button type="button" class="btn btn-warning"><a style="color: white; text-decoration: none" href="/student/${student.id}">Изменить</a></button></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col">
            <h3>Добавить студента</h3>
            <form action="/student" method="post">
                <div class="form-group">
                    <label for="surname">Фамилия</label>
                    <input class="form-control" type="text" name="surname" required>
                </div>
                <div class="form-group">
                    <label for="firstname">Имя</label>
                    <input class="form-control" type="text" name="firstname" required>
                </div>
                <div class="form-group">
                    <label for="patronymic">Отчество</label>
                    <input class="form-control" type="text" name="patronymic" required>
                </div>
                <div class="form-group">
                    <label for="age">Возраст</label>
                    <input class="form-control" type="number" name="age" required>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Группа</label>
                    <select name="groupStudId" class="form-control" id="exampleFormControlSelect1">
                        <#list groups as group>
                            <option value="${group.id}">${group.faculty}: ${group.name}</option>
                        </#list>
                    </select>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
    </div>
</@c.page>
