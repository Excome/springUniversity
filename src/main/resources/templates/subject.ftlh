<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="row">
        <div class="col-8">
            <table class="table" style="text-align: center">
                <thead class="thead-dark">
                <tr>
                    <th>Тип</th>
                    <th>Название</th>
                    <th>Количество часов в неделю</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <#list subjects as subject>
                    <tr>
                        <td>${subject.type?string("Техническая наука", "Гуманитарная наука")}</td>
                        <td>${subject.name}</td>
                        <td>${subject.hoursPerWeek}</td>
                        <td><a href="/subject/${subject.id}">Изменить</a></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col">
            <h3>Добавить предмет</h3>
            <form action="/subject" method="post">
                <div class="form-group">
                    <label for="type">Тип предмета</label>
                    <select name="type" class="form-control" id="exampleFormControlSelect1">
                        <option value="1">Техническая наука</option>
                        <option value="0">Гуманитарная наука</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="name">Название</label>
                    <input class="form-control" type="text" name="name" required>
                </div>
                <div class="form-group">
                    <label for="hoursPerWeek">Количество часов в неделю</label>
                    <input class="form-control" type="number" name="hoursPerWeek" required>
                </div>
                <button type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
    </div>
</@c.page>