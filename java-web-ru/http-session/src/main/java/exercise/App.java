package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

            ctx.json(getUsersParam(USERS, page, per));

        });

        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    public static List<Map<String, String>> getUsersParam(List<Map<String, String>> users, int page, int per) {
        List<Map<String, String>> users_select = new ArrayList<>();
        int start = (page - 1) * per;
        int end = page * per;
        for (int i = 0; i < users.size(); i++) {
            if (i >= start && i < end ) {
                Map<String, String> user = users.get(i);
                //user.put("id", ids.get(i));
                //user.put("firstName", faker.name().firstName());
                //user.put("lastName", faker.name().lastName());
                users_select.add(user);
            }
        }
        return users_select;
    }
}
