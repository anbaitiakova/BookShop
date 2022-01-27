<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>
    <h5>${name}</h5>
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Email:  </label>
            <div class="col-sm-5">
                <input type="text" name="email" class="form-control" placeholder="Email" value="${email!''}"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Пароль:  </label>
            <div class="col-sm-5">
                <input type="text" name="customer_password" class="form-control" placeholder="Пароль"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-primary mb-3" type="submit">Сохранить</button>
    </form>
</@c.page>