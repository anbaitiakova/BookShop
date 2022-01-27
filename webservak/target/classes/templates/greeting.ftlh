<#import "parts/common.ftlh" as c>
<link href="http://fonts.googleapis.com/css?family=PT+Sans:regular,italic,bold,bolditalic" rel="stylesheet" type="text/css" />

<@c.page>
    <h3>BOOKS FOR EVERYONE</h3>

    <h5 class="mb-3">Для покупки книг - авторизируйтесь <a href="/login">Войти</a></h5>

    <div class="form-row">
        <div class="form-group col-md-10">
            <form method="get" action="/main" style="display:inline">
                <input type="text" name="filter" placeholder="Введите название книги" value="${filter?ifExists}">
                <button class="btn btn-primary ml-1" type="submit">Найти</button>
            </form>
            <form method="get" action="/main" style="display:inline">
                <input class="ml-3" type="text" name="filterAuthor" placeholder="Введите автора" value="${filterAuthor?ifExists}">
                <button class="btn btn-primary ml-1 " type="submit">Найти</button>
            </form>
            <form  method="get" action="/userPage" style="display:inline">
                <input class="ml-3" type="text" name="filterGenre" placeholder="Введите жанр" value="${filterGenre?ifExists}">
                <button class="btn btn-primary ml-1" type="submit">Найти</button>
            </form>
        </div>
    </div>
    <div class="card-columns">
        <#list books as book>
            <div class="card bg-light my-3">
                <div class="card-body m-1">
                    <h4 class="card-title" style="color:#191970">${book.title}</h4>
                    <h6 class="card-subtitle mb-2" style="color:#00008B"> ${book.author.author_name}</h6>
                    <p class="card-text"><b>Жанр:</b> ${book.genre.genre_name}</p>
                    <p class="card-text"><b>Возрастное ограничение:</b> ${book.age.age_number}+</p>
                    <p class="card-text"><b>Издательство:</b> ${book.publisher.publisher_name}</p>
                    <p class="card-text"><b>Год издания:</b> ${book.year_publ}</p>
                    <p class="card-text"><b>ISBN:</b> ${book.isbn}</p>
                    <h5 class="card-text" style="color:#00008B"><b>${book.price}</b><span class="rubl">&#8399;</span></h5>
                    <!--p class="card-text"><b>Количество:</b> ${book.amount}</p-->
                </div>
            </div>
        <#else>
            Нет книг в наличии
        </#list>
    </div>
</@c.page>

