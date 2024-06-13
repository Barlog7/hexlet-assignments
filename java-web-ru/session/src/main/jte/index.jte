@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
content = @`
    <div>
    @if( page.getError() != null)
        ${page.getError()}
        <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
    @else
        Пользователь ${page.getName()}

        <a href="${NamedRoutes.logoutPath()}">Выйти</a>
    @endif
    </div>


`
)