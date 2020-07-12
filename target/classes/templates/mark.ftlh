<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="row">
        <div class="col-9">
            <div class="mb-2">
                <form class="form-inline" method="get">
                    <input name="search" class="form-control mr-sm-2" type="search" value="${search}" placeholder="Поиск.." aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
                </form>
            </div>
            <table class="table" style="text-align: center">
                <thead class="thead-dark">
                <tr>
                    <th>Студент</th>
                    <th>Предмет</th>
                    <th>Оценка</th>
                    <th>Преподаватель</th>
                    <th>Работа</th>
                    <th>Дата</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <#list marks as mark>
                    <tr>
                        <td>${mark.studentName}</td>
                        <td>${mark.subject.name}</td>
                        <td>${mark.mark}</td>
                        <td>${mark.teacherName}</td>
                        <td>${mark.work}</td>
                        <td>${mark.date}</td>
                        <td><button type="button" class="btn btn-warning"><a style="color: white; text-decoration: none" href="/mark/${mark.id}">Изменить</a></button></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col">
            <h3>Добавить оценку</h3>
            <form action="/mark" method="post">
                <div class="form-group">
                    <label for="student">Студент</label>
                    <select name="studentId" class="form-control" id="exampleFormControlSelect1">
                        <#list students as student>
                            <option value="${student.id}">${student.surname} ${student.firstname} ${student.patronymic}</option>
                        </#list>
                    </select>
                </div>
                <div class="form-group">
                    <label for="subject">Предмет</label>
                    <select name="subjectId" class="form-control" id="exampleFormControlSelect1">
                        <#list subjects as subject>
                            <option value="${subject.id}">${subject.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="form-group">
                    <label for="mark">Оценка</label>
                    <input class="form-control" type="text" name="mark" required>
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
                    <label for="work">Работа</label>
                    <input class="form-control" type="text" name="work" required>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Дата</label>
                    <input class="form-control" type="date" name="date" required>
                </div>
                <button type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
    </div>
</@c.page>