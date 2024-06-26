package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import java.util.List;
import java.util.Optional;

import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/articles/build", ctx -> {
            var page = new BuildArticlePage();
            ctx.render("articles/build.jte", model("page", page));
        });

        app.post("/articles", ctx -> {
            try {
/*            var name = ctx.formParam("name").trim();
              var description = ctx.formParam("description").trim().toLowerCase();*/
                //var title = ctx.formParam("title").trim();
                //var context = ctx.formParam("context").trim().toLowerCase();
                /*var title = ctx.formParamAsClass("title", String.class)
                        .check(value -> value.trim().length() > 2, "Название не должно быть короче двух символов")
                        .check(value -> ArticleRepository.findByTitle(value).isPresent(), "Статья с таким названием уже существует")
                        .get();*/
                //var title = ctx.formParamAsClass("title", String.class).get();
                //Optional<Article> b1 = ArticleRepository.findByTitle(title);
                //var b4 = b1.isPresent();
                //boolean b2 = ArticleRepository.findByTitle(title).isPresent();
                var title = ctx.formParamAsClass("title", String.class)
                        .check(value -> value.trim().length() > 2, "Название не должно быть короче двух символов")
                        .check(value -> ArticleRepository.findByTitle(value).isEmpty(), "Статья с таким названием уже существует")
                        .get();

                var context = ctx.formParamAsClass("content", String.class)
                        .check(value -> value.trim().length() >10, "Статья должна быть не короче 10 символов")
                        .get();

                Article article = new Article(title, context);
                ArticleRepository.save(article);
                ctx.redirect("/articles");
            } catch (ValidationException e) {
                var title = ctx.formParam("title");
                var context = ctx.formParam("content");
                var page = new BuildArticlePage(title, context, e.getErrors());
                ctx.render("articles/build.jte", model("page", page)).status(422);
            }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
