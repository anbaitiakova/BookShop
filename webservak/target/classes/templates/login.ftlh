<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>
    <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
        <div class="alert alert-danger" role="alert">
            ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
    </#if>
<h2 class="mb-3">Вход в личный кабинет</h2>
<form action="/login" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Имя:  </label>
        <div class="col-sm-5">
            <input type="text" name="username"
                   class="form-control ${(usernameError??)?string('is-invalid', '')}"
                   placeholder="Имя пользователя"/>
            <#if usernameError??>
                <div class="invalid-feedback">
                    ${usernameError}
                </div>
            </#if>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Пароль:  </label>
        <div class="col-sm-5">
            <input type="password" name="customer_password"
                   class="form-control ${(customer_passwordError??)?string('is-invalid', '')}"
                   placeholder="Пароль"/>
            <#if customer_passwordError??>
                <div class="invalid-feedback">
                    ${customer_passwordError}
                </div>
            </#if>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <button class="btn btn-primary mb-3" type="submit">Войти</button>
</form>
<div>Еще нет аккаунта? <a href="/registration"> Зарегистрироваться</a></div>
</@c.page>