<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<link href="http://fonts.googleapis.com/css?family=PT+Sans:regular,italic,bold,bolditalic" rel="stylesheet" type="text/css" />
<@c.page>

    <h2>Заказ № ${orderNumber} на сумму ${sum} <span class="rubl">&#8399;</span></h2>
    <h5 style="color:#00008B"><#if ifDiscount??>Применен промокод: ${ifDiscount}</#if></h5>
    <div></div>
    <h2>Спасибо за Ваш заказ</h2>
    <h3>Он будет доставлен в ближайшее время!</h3>
    <h3>${name}, ждем Вас снова!</h3>
    <h5>Вернуться на <a href="/userPage">Главную</a></h5>
</@c.page>