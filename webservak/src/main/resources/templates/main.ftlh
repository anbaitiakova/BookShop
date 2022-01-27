<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<link href="http://fonts.googleapis.com/css?family=PT+Sans:regular,italic,bold,bolditalic" rel="stylesheet" type="text/css" />

<@c.page>
<#if isAdmin>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить Книгу
    </a>
    <div class="collapse" id="collapseExample">
        <div  class="form-group mt-3">
            <form method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="title" placeholder="title" required>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="isbn" placeholder="isbn" required minlength="13" maxlength="13">
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" name="year_publ" placeholder="year_publ" required min="1425" max="2022">
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" name="price" placeholder="price" required min="1">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="author" placeholder="author" required>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="genre" placeholder="genre" required>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="publisher" placeholder="publisher" required>
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" name="age" placeholder="age" required min="0" max="18">
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" name="amount" placeholder="amount" required min="1">
                </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>

</#if>
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
                <p class="card-text"><b>Количество:</b> ${book.amount}</p>
                <a class="col btn btn-primary" href="/edit/${book.book_id}">Редактировать</a>
            </div>
        </div>
        <#else>
        Нет книг в наличии
    </#list>
    </div>
</@c.page>
