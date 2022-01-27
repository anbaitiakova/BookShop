<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<@c.page>
<div  class="form-group mt-10">
    <form method="post">
        <div class="form-group mt-10">
            <label>Город доставки: </label>
            <select name="citySelect" class="form-control selectpicker mb-3">
                <#if city?has_content>
                    <#list city as way>
                        <option value="${way.city_name}">${way.city_name}</option>
                    </#list>
                </#if>
            </select>
            <input type="text" class="form-control mb-3" name="address" placeholder="Адрес">
            <input type="text" class="form-control mb-3" name="order_comments" placeholder="Комментарии к заказу">
            <input type="text" class="form-control mb-3" name="promo_code" placeholder="Промокод">
            <label>Способ доставки: </label>
            <select name="waysSelect" class="form-control selectpicker mb-3">
                <#if waysOfDeliveries?has_content>
                    <#list waysOfDeliveries as way>
                        <option value="${way.ways}">${way.ways} ${way.delivery_price}</option>
                    </#list>
                </#if>
            </select>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group">
            <button type="submit" class="btn btn-primary mt-1 ">Оплатить</button>
        </div>
    </form>
</div>
</@c.page>