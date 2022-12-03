<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main>

<@main.renderWith scripts=[]>
    <#if tasks?? && tasks?has_content>
        <div>
            <table class="table">
                <thead>
                <tr>
                    <td>name</td>
                    <td>status</td>
                    <td>developer</td>
                    <#if principal??>
                        <td>view</td>
                    </#if>
                </tr>
                </thead>
                <tbody>
                <#list tasks as task>
                    <tr>
                        <td>${task.name}</td>
                        <td>${task.status}</td>
                        <td>${task.developer}</td>
                        <#if principal??>
                            <td><a href="/tasks/view?id=${task.id}">view</a></td>
                        </#if>
                    </tr>
                </#list>
                </tbody>
            </table>

        </div>
    </#if>

</@main.renderWith>