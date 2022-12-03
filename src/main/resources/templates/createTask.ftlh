<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main>

<@main.renderWith scripts=[ "/js/ticket.js"]>

    <form action="/tasks/create" method="post">
            <#if _csrf??>
                <input type="hidden"
                       name="${(_csrf.parameterName)!'csrf-param-name'}" value="${(_csrf.token)!'csrf-token'}">
            </#if>
            <div class="mb-3">
                <label for="name" class="form-label"><@spring.message "label.name"/></label>
                <input type="text" class="form-control" id="name" name="name" required
                       minlength="6">
            </div>

            <div class="mb-3">
                <label for="login" class="form-label"><@spring.message "label.login"/></label>
                <input type="datetime-local" class="form-control" id="createdTime" name="createdTime" required
                       minlength="6">
            </div>
            <input type="submit">
    </form>


</@main.renderWith>