package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        //ctx.redirect("build.jte");
        ctx.render("build.jte");
    }
    public static void login(Context ctx) {
        //var name = ctx.formParam("name");
        //var curname = ctx.sessionAttribute("name");
        var name = ctx.formParam("nickname");
        var password = ctx.formParam("password");
        var user = UsersRepository.findByName(name);
        //String error = null;

        if (user != null && user.getPassword().equals(Security.encrypt(password))) {
            //ctx.sessionAttribute("login", "yes");
            ctx.sessionAttribute("name", name);
            //ctx.sessionAttribute("error", null);
        } /*else {
            error = "Wrong username or password.";
            //ctx.sessionAttribute("error", error);
        }*/

        //var page = new LoginPage(name, error);
        //ctx.render("index.jte", model("page", page));
        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("name", null);

        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void show(Context ctx) {

            var name = ctx.sessionAttribute("name");
            String error = null;
            if (name == null) {
                error = "Wrong username or password.";
            }
            var page = new LoginPage((String) name, error);
            ctx.render("index.jte", model("page", page));

        //ctx.redirect(NamedRoutes.rootPath());
    }


    // END
}
