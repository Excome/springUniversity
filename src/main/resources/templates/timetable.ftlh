<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="row">
        <div class="col-9">
            <table class="table" style="text-align: center">
                <thead class="thead-dark">
                <tr>
                    <th>Предмет</th>
                    <th>Преподаватель</th>
                    <th>Группа</th>
                    <th>Аудитория</th>
                    <th>Дата и время</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <#list timetables as timetable>
                    <tr>
                        <td>${timetable.subject.name}</td>
                        <td>${timetable.teacherName}</td>
                        <td>${timetable.groupStud.name}</td>
                        <td>${timetable.room}</td>
                        <td>${timetable.datetime}</td>
                        <td><button type="button" class="btn btn-warning"><a style="color: white; text-decoration: none" href="/timetable/${timetable.id}">Изменить</a></button></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col">
            <h3>Добавить запись в расписание</h3>
            <form action="/timetable" method="post">
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
                    <input class="form-control" type="text" name="room" required>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Дата и время занятия</label>
                    <input class="form-control" type="datetime-local" name="datetime" required>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
    </div>
</@c.page>