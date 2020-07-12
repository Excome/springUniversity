<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="container">
        <h3>Изменение записи оценки</h3>

        <form action="/mark/update" method="post">
            <div class="form-group">
                <label for="student">Студент</label>
                <select name="studentId" class="form-control" id="exampleFormControlSelect1">
                    <#list students as student>
                        <option value="${student.id}" <#if (student.id == mark.student.id)>selected</#if>>${student.surname} ${student.firstname} ${student.patronymic}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="subject">Предмет</label>
                <select name="subjectId" class="form-control" id="exampleFormControlSelect1">
                    <#list subjects as subject>
                        <option value="${subject.id}" <#if (subject.id == mark.subject.id)>selected</#if> >${subject.name}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="mark">Оценка</label>
                <input name="mark" class="form-control" type="text" value="${mark.mark}" required>
            </div>
            <div class="form-group">
                <label for="teacher">Преподаватель</label>
                <select name="teacherId" class="form-control" id="exampleFormControlSelect1">
                    <#list teachers as teacher>
                        <option value="${teacher.id}" <#if (teacher.id == mark.teacher.id)>selected</#if> >${teacher.surname} ${teacher.firstname} ${teacher.patronymic}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="work">Работа</label>
                <input class="form-control" type="text" name="work" value="${mark.work}" required>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect1">Дата</label>
                <input class="form-control" type="date" name="date" value="${mark.date}" required>
            </div>

            <input type="hidden" name="markId" value="${mark.id}">
            <button type="submit" class="btn btn-success" style="float: left">Изменить</button>
        </form>

        <form action="/mark/delete" method="post">
            <input type="hidden" name="timetableId" value="${mark.id}">
            <button type="submit" class="btn btn-danger ml-2"  style="float: right">Удалить</button>
        </form>
    </div>
</@c.page>