/**
 * Created by kris on 16/10/23.
 */
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");

        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });

        get("/joke", (request, response) -> {
            return "This is a joke fetched from backend server. (Spark Framework)";
        });
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

}
