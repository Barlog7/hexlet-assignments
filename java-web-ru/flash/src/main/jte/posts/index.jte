@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
page = page,
content = @`

@for(var post : page.getPosts())
<%--<div>${course.getName()}</div>--%>
<%--<h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>--%>
    <%--<h2><a href="${NamedRoutes.usersPath(user.getId())}">${user.getName()}</a></h2>
    <p>${user.getMail()}</p>--%>
    <div>
        ${post.getId()}
        ${post.getName()}
        ${post.getBody()}
    </div>

@endfor
`
)