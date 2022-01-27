<#import "parts/common.ftlh" as c>
<@c.page>
<div  class="form-group mt-3">
    <form method="post">
        <div class="form-group">
            <input type="number" class="form-control" name="amount" placeholder="Количество экземпляров" required min="0">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Обновить количество</button>
        </div>
    </form>
</div>
</@c.page>