<#import "parts/common.ftlh" as c>
<@c.page>
    <#if message??>
        <div class="alert alert-warning" role="alert">
            ${message}
        </div>
    </#if>
<h2 class="mb-3">Регистрация</h2>
<form action="/registration" method="post">
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
        <label class="col-sm-2 col-form-label"> Email:  </label>
        <div class="col-sm-5">
            <input type="email" name="email"
                   class="form-control ${(emailError??)?string('is-invalid', '')}"
                   placeholder="Email"/>
                <#if emailError??>
                    <div class="invalid-feedback">
                        ${emailError}
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
    <button class="btn btn-primary mb-3" type="submit">Зарегистрироваться</button>
</form>
<div><a href="/login">Уже зарегистрирован(а)</a></div>
</@c.page>