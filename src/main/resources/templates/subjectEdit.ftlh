<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container">
        <h3>Изменение предмета</h3>
        <form action="/subject/update" method="post">
            <div class="form-group">
                <label for="type">Тип предмета</label>
                <select name="type" class="form-control" id="exampleFormControlSelect1">
                    <option value="1">Техническая наука</option>
                    <option value="0">Гуманитарная наука</option>
                </select>
            </div>
            <div class="form-group">
                <label for="name">Имя</label>
                <input class="form-control" type="text" name="name" value="${subject.name}" required>
            </div>
            <div class="form-group">
                <label for="hoursPerWeek">Количество часов в неделю</label>
                <input class="form-control" type="number" name="hoursPerWeek" value="${subject.hoursPerWeek}" required>
            </div>
            <input type="hidden" name="subjectId" value="${subject.id}">
            <button type="submit" class="btn btn-primary" style="float: left">Изменить</button>
        </form>
        <form action="/subject/delete" method="post">
            <input type="hidden" name="subjectId" value="${subject.id}">
            <button type="submit" class="deleteBtn btn btn-primary ml-2">Удалить</button>
        </form>
    </div>
</@c.page>
