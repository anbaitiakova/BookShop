<#assign known = Session.SPRING_SECURITY_CONTEXT??>
 <#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        email = user.getEmail()
        isAdmin = user.isAdmin()
        isUser = user.isUser()
    >
     <#else>
        <#assign
            name = ""
            isAdmin = false
            isUser = false
        >
</#if>