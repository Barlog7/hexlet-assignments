package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;


public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            var users = USERS;
            //var header = "Курсы по программированию";
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        app.get("/users/{id}", ctx -> {
            //long id = ctx.pathParam("id");
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var user =  USERS.stream()
                    .filter(c -> c.getId() == id)
                    .findFirst()
                    .orElse(null);
            if (user == null) {
                throw new NotFoundResponse("User not found");
            }
            /*var course = new Course("","");
            switch (id) {
                case "1":
                    course = course1;
                    break;
                case "2":
                    course = course2;
                    break;
                default:
                    course = course3;
                    break;
            }*/
            //var course = "/* Курс извлекается из базы данных. Как работать с базами данных мы разберем в следующих уроках */";
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
