<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link border border-light rounded" href="/">Главная</a>
                </li>
                <#if principal?? && principal.role == "MANAGER">
                    <li class="nav-item">
                        <a class="nav-link border border-light rounded" href="/users/create">Зарегистрировать пользователя</a>
                    </li>
                </#if>
                <#if principal?? && principal.role == "MANAGER">
                    <li class="nav-item">
                        <a class="nav-link border border-light rounded" href="/tasks/create">Зарегистрировать таск</a>
                    </li>
                </#if>

            </ul>
            <hr class="d-lg-none">
            <hr class="d-lg-none">
            <#if username??>
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item me-2">
                        <a class="btn btn-success" href="/logout">Выйти</a>
                    </li>
                </ul>
            <#else>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item me-2">
                    <a class="btn btn-success" href="/login">Вход</a>
                </li>
            </ul>
            </#if>
        </div>
    </div>
</nav>