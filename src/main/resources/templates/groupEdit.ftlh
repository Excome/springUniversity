<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container">
        <h3>Изменение группы</h3>
        <form action="/group/update" method="post">
            <div class="form-group">
                <label for="faculty">Факультет</label>
                <input class="form-control" type="text" name="faculty" value="${group.faculty}" required>
            </div>
            <div class="form-group">
                <label for="direction">Направление</label>
                <input class="form-control" type="text" name="direction"  value="${group.direction}" required>
            </div>
            <div class="form-group">
                <label for="name">Название группы</label>
                <input class="form-control" type="text" name="name" value="${group.name}" required>
            </div>
            <input type="hidden" name="groupId" value="${group.id}">
            <button type="submit" class="btn btn-primary" style="float: left">Изменить</button>
        </form>
        <form action="/group/delete" method="post">
            <input type="hidden" name="groupId" value="${group.id}">
            <button type="submit" class="deleteBtn btn btn-primary ml-2">Удалить</button>
        </form>
    </div>
</@c.page>
