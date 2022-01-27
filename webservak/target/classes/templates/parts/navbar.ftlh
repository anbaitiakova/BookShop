<#include "security.ftlh">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <#if isAdmin>
        <a class="navbar-brand" href="/main">BOOKS FOR EVERYONE</a>
    <#elseif isUser>
        <a class="navbar-brand" href="/userPage">BOOKS FOR EVERYONE</a>
    <#else>
        <a class="navbar-brand" href="/">BOOKS FOR EVERYONE</a>
    </#if>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#--<li class="nav-item">
                <a class="nav-link" href="/">greeting(убрать)</a>
            </li>-->
            <#if isUser>
            <li class="nav-item">
                <a class="nav-link" href="/userPage">Книги</a>
            </li>
            <#elseif isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/userPage">Книги</a>
                </li>
            <#else>
                <li class="nav-item">
                    <a class="nav-link" href="/">Книги</a>
                </li>
            </#if>

            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">Список пользователей</a>
                </li>
            </#if>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile">Профиль</a>
                </li>
            </#if>

        </ul>
        <div class="navbar-text mr-3">${name}</div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button class="btn btn-primary" type="submit">Выйти</button>
        </form>
    </div>
</nav>