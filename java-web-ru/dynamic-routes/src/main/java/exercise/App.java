package exercise;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Map;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.exception(NotFoundResponse.class, (e, ctx) -> {
            ctx.status(404);
        }).error(404, ctx -> {
            //var id = ctx.pathParam("id");
            ctx.result("Company not found");
        });

        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var idNumber = ctx.pathParamAsClass("id", Long.class).get();
            //ctx.result("Course ID: " + ctx.pathParam("id"));
            Map<String, String> map = getCompanyMap(COMPANIES, id);
            if (map == null) {
                throw new NotFoundResponse("Entity with id = " + id + " not found");
            }
            ctx.json(getCompanyMap(COMPANIES, id));
            //ctx.json(COMPANIES);
        });


       /* app.error(404, ctx -> {
            ctx.result("Generic 404 message");
        });*/
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    public static Map<String, String> getCompanyMap(List<Map<String, String>> listMaps, String id) {
        for (var map : listMaps) {
            var curId = map.get("id");
            if (curId.equals(id)) {
                return map;
            }
        }
        return null;
    }
/*    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        // Позже мы разберем эти конструкции подробнее
        var user = UserRepository.find(id) // Ищем пользователя в базе по id
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
    }*/
}
