@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <div><a href="${NamedRoutes.postsPath()}">Список постов</a></div>


    <div>${page.getPost().getId()}</div>
    <div>${page.getPost().getName()}</div>
    <div>${page.getPost().getBody()}</div>


`
)