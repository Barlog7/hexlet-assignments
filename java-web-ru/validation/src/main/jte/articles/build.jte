@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif
    <form action="/articles" method="post">
        <div>
            <label>
                Название статьи
                <input type="text" name="title" value="${page.getTitle()}" />
            </label>
        </div>
        <div>
            <label>
                Содержимое статьи
                <%--<textarea type="text" required name="context" value="${page.getContent()}" />--%>
                <textarea type="text" name="content" required>${page.getContent()}</textarea>
            </label>
        </div>
        <input type="submit" value="Добавить" />
    </form>
`
)
