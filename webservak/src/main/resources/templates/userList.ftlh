<#import "parts/common.ftlh" as c>
<@c.page>
    <b>Список пользователей</b>
<table>
    <thead>
    <tr>
        <th>Имя пользователя</th>
        <th>Роль</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/user/${user.customer_id}">Редактировать</a> </td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>