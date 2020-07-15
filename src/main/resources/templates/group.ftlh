<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="row">
        <div class="col-9">
            <table class="table" style="text-align: center">
                <thead class="thead-dark">
                <tr>
                    <th>Факультет</th>
                    <th>Направление</th>
                    <th>Группа</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <#list groups as group>
                    <tr>
                        <td>${group.faculty}</td>
                        <td>${group.direction}</td>
                        <td>${group.name}</td>
                        <td><button type="button" class="btn btn-warning"><a style="color: white; text-decoration: none" href="/group/${group.id}">Изменить</a></button></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col">
            <h3>Добавить группу</h3>
            <form action="/group" method="post">
                <div class="form-group">
                    <label for="faculty">Факультет</label>
                    <input class="form-control" type="text" name="faculty" required>
                </div>
                <div class="form-group">
                    <label for="direction">Направление</label>
                    <input class="form-control" type="text" name="direction" required>
                </div>
                <div class="form-group">
                    <label for="name">Название группы</label>
                    <input class="form-control" type="text" name="name" required>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
    </div>
</@c.page>