package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        var posts = PostRepository.getEntities();
        var kolPosts = (int) Math.ceil(posts.size() / 5);
        //var numpage = ctx.queryParam("page");
        var numpage = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var offset = (numpage - 1) * 5;
        var modPosts = posts.subList(offset, offset + 5);

        var page = new PostsPage(modPosts, numpage, kolPosts);
        ctx.render("posts/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        try {
            var post = PostRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Page not found"));
            var page = new PostPage(post);
            ctx.render("posts/show.jte", model("page", page));
        } catch (NotFoundResponse e) {
            ctx.result("Page not found").status(404);
        }
    }
    // END
}
