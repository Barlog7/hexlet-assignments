@import exercise.util.NamedRoutes

<!-- sessions/build.jte -->
<!-- Нужно не забыть добавить маршрут в NamedRoutes -->
<form action="${NamedRoutes.loginPath()}" method="post">
    <input type="text" placeholder="Nickname" name="nickname" />
    <input type="password" placeholder="Password" name="password" />
    <input type="submit" value="Войти"/>
</form>