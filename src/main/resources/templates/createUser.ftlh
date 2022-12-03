<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main>

<@main.renderWith scripts=[ "/js/ticket.js"]>

    <form action="/users/create" method="post">
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
                <label for="email" class="form-label"><@spring.message "label.email"/></label>
                <input type="text" class="form-control" id="email" name="email" required
                       minlength="6">
            </div>

            <div class="mb-3">
                <label for="login" class="form-label"><@spring.message "label.login"/></label>
                <input type="email" class="form-control" id="login" name="login" required
                       minlength="6">
            </div>

            <div class="mb-3">
                <label for="password" class="form-label"><@spring.message "label.pass"/></label>
                <input type="password" class="form-control" id="password" name="password" placeholder="********"
                       required minlength="6">
            </div>

            <div class="mb-3 text-center">
                <label for="password" class="form-label"><@spring.message "label.role"/></label>
                <select name="role" id="option" class="form-control">
                    <option value="MANAGER">MANAGER</option>
                    <option value="DEVELOPER">DEVELOPER</option>
                </select>
            </div>
            <input type="submit">
    </form>


</@main.renderWith>