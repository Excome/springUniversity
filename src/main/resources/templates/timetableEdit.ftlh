<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container">
        <h3>Изменение записи расписания</h3>
        <form action="/timetable/update" method="post">
            <div class="form-group">
                <label for="subject">Предмет</label>
                <select name="subjectId" class="form-control" id="exampleFormControlSelect1">
                    <#list subjects as subject>
                        <option value="${subject.id}">${subject.name}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="teacher">Преподаватель</label>
                <select name="teacherId" class="form-control" id="exampleFormControlSelect1">
                    <#list teachers as teacher>
                        <option value="${teacher.id}">${teacher.surname} ${teacher.firstname} ${teacher.patronymic}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="group">Группа</label>
                <select name="groupId" class="form-control" id="exampleFormControlSelect1">
                    <#list groups as group>
                        <option value="${group.id}">${group.name}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="room">Аудитория</label>
                <input class="form-control" type="text" name="room" value="${timetable.room}" required>
            </div>
            <div class="form-group">
                <label for="datetime">Дата и время занятия</label>
                <input class="form-control" type="datetime-local" name="datetime" required>
            </div>
            <input type="hidden" name="timetableId" value="${timetable.id}">
            <button type="submit" class="btn btn-primary">Изменить</button>
        </form>
        <form action="/timetable/delete" method="post">
            <input type="hidden" name="timetableId" value="${timetable.id}">
            <button type="submit" class="deleteBtn btn btn-primary ml-2">Удалить</button>
        </form>
    </div>
</@c.page>