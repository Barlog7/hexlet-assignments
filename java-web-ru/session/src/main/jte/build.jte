@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes

@param LoginPage page

<!-- sessions/build.jte -->
<!-- Нужно не забыть добавить маршрут в NamedRoutes -->
@template.layout.page(
content = @`
@if(page.getError() != null)
    ${page.getError()}
@endif
<form action="${NamedRoutes.loginPath()}" method="post">
    <input type="text" placeholder="Nickname" name="nickname" />
    <input type="password" placeholder="Password" name="password" />
    <input type="submit" value="Войти"/>
</form>

`
)