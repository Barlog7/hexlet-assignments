@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get">

        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Искать">
    </form>

    @for(var user : page.getUsers())
    <%--<div>${course.getName()}</div>--%>
        <h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
        <p>${user.getEmail()}</p>
    @endfor
`
)