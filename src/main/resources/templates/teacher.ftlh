<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="row">
        <div class="col-8">
            <table class="table" style="text-align: center">
                <thead class="thead-dark">
                <tr>
                    <th>Фамилия</th>
                    <th>Имя</th>
                    <th>Отчество</th>
                    <th>Возвраст</th>
                    <th>Ученая степень</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <#list teachers as teacher>
                    <tr>
                        <td>${teacher.surname}</td>
                        <td>${teacher.firstname}</td>
                        <td>${teacher.patronymic}</td>
                        <td>${teacher.age}</td>
                        <td>${teacher.degree}</td>
                        <td><a href="/teacher/${teacher.id}">Изменить</a></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col">
            <h3>Добавить преподавателя</h3>
            <form action="/teacher" method="post">
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
                    <label for="exampleFormControlSelect1">Ученая степень</label>
                    <select name="degree" class="form-control" id="exampleFormControlSelect1">
                        <option value="тест">тест</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
    </div>
</@c.page>