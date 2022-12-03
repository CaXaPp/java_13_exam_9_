<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main>

<@main.renderWith scripts=[]>
    <#if task??>
        <div>
            <table class="table">
                <thead>
                <tr>
                    <td>name</td>
                    <td>status</td>
                    <td>developer</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${task.name}</td>
                    <td>${task.status}</td>
                    <td>${task.developer}</td>
                </tr>
                </tbody>
            </table>

        </div>
    </#if>
    <br><br><br><br><br>
    <hr>
    <#if principal?? && principal.role == "MANAGER">
        <div class="card">
            <div class="card-body">
                <div class="card-title">Assign</div>
                <form action="/tasks/assign?id=${task.id}" method="post">
                    <#if _csrf??>
                        <input type="hidden"
                               name="${(_csrf.parameterName)!'csrf-param-name'}" value="${(_csrf.token)!'csrf-token'}">
                    </#if>

                    <div class="mb-3 text-center">
                        <p>Developer</p>
                        <select name="userId" id="option" class="form-control">
                            <#list developers as dev>
                                <option value="${dev.id}">${dev.name}</option>
                            </#list>
                        </select>
                    </div>

                    <input type="submit">
                </form>
            </div>
        </div>
    </#if>
    <br><br><br><br><br>
    <hr>
    <#if principal?? && principal.role.name() == "MANAGER" || principal?? && task.developerId?? && principal.id == task.developerId>
        <div class="card">
            <div class="card-body">
                <div class="card-title">EDIT</div>
                <form action="/tasks/edit?id=${task.id}" method="post">
                    <#if _csrf??>
                        <input type="hidden"
                               name="${(_csrf.parameterName)!'csrf-param-name'}" value="${(_csrf.token)!'csrf-token'}">
                    </#if>
                    <div class="mb-3">
                        <label for="name" class="form-label"><@spring.message "label.name"/></label>
                        <input type="text" class="form-control" id="name" name="name" value="${task.name}" required
                               minlength="6">
                    </div>

                    <select name="status" id="option" class="form-control">

                        <option value="CREATED">CREATED</option>
                        <option value="IN_PROCESS">IN_PROCESS</option>
                        <option value="COMPLETED">COMPLETED</option>
                        <option value="FAILED">FAILED</option>

                    </select>
                    <input type="submit">
                </form>
            </div>
        </div>
    </#if>
    <br><br><br><br><br>
    <hr>
    <hr>
    <#if workLogs?? && workLogs?has_content>
        <div>
            <table class="table">
                <thead>
                <tr>
                    <td>DateTime</td>
                    <td>Time</td>
                    <td>Description</td>
                </tr>
                </thead>
                <tbody>
                <#list workLogs as wl>
                <tr>

                        <td>${wl.createdTime}</td>
                        <td>${wl.time}</td>
                        <td>${wl.description}</td>

                </tr>
                </#list>
                </tbody>
            </table>

        </div>
    </#if>
    <hr>
    <#if principal?? && task.developerId?? && principal.id == task.developerId>
        <div class="card">
            <div class="card-body">
                <div class="card-title">Add WORK</div>
                <form action="/tasks/addwork?id=${task.id}" method="post">
                    <#if _csrf??>
                        <input type="hidden"
                               name="${(_csrf.parameterName)!'csrf-param-name'}" value="${(_csrf.token)!'csrf-token'}">
                    </#if>
                    <div class="mb-3">
                        <p>Time</p>
                        <input type="text" class="form-control" id="time" name="time" required
                               minlength="6">
                    </div>

                    <div class="mb-3">
                        <p>Description</p>
                        <input type="text" class="form-control" id="description" name="description"  required
                               minlength="6">
                    </div>

                    <input type="submit" value="Add">
                </form>
            </div>
        </div>
    </#if>


</@main.renderWith>