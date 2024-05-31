@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    <p>Посты</p>
    @for(var post : page.getPosts())
        <p><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></p>
    @endfor


    @if(page.getNumpage() != 1)
        <p><a href="${NamedRoutes.postsPath()}?page=${page.getNumpage()-1}">назад</a></p>
    @endif

    @if(page.getNumpage() != page.getMaxpage())
        <p><a href="${NamedRoutes.postsPath()}?page=${page.getNumpage()+1}">вперед</a></p>
    @endif
`
)