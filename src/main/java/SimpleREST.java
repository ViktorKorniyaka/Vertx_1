import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
//import io.vertx.example.util.Runner;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.HashMap;
import java.util.Map;

public class SimpleREST extends AbstractVerticle {
    private static final String WEB_EXAMPLES_DIR = "web-examples";
    private static final String WEB_EXAMPLES_JAVA_DIR = WEB_EXAMPLES_DIR + "/src/main/java/";
/*    public static void runExample(Class clazz) {
        runExample(WEB_EXAMPLES_JAVA_DIR, clazz, new VertxOptions().setClustered(false), null);
    }
    public static void runExample(String exampleDir, Class clazz, VertxOptions options, DeploymentOptions
            deploymentOptions) {
        runExample(exampleDir + clazz.getPackage().getName().replace(".", "/"), clazz.getName(), options, deploymentOptions);
    }*/
    // Convenience method so you can run it in your IDE
    public static void main(String[] args) {
        Runner.runExample(SimpleREST.class);
    }

    private Map<String, JsonObject> products = new HashMap<>();

    @Override
    public void start() {

        setUpInitialData();

        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());
        router.get("/products/:productID").handler(this::handleGetProduct);
        router.put("/products/:productID").handler(this::handleAddProduct);
        router.get("/products").handler(this::handleListProducts);

        vertx.createHttpServer().requestHandler(router).listen(8080);
    }

    private void handleGetProduct(RoutingContext routingContext) {
        String productID = routingContext.request().getParam("productID");
        HttpServerResponse response = routingContext.response();
        if (productID == null) {
            sendError(400, response);
        } else {
            JsonObject product = products.get(productID);
            if (product == null) {
                sendError(404, response);
            } else {
                response.putHeader("content-type", "application/json").end(product.encodePrettily());
            }
        }
    }

    private void handleAddProduct(RoutingContext routingContext) {
        String productID = routingContext.request().getParam("productID");
        HttpServerResponse response = routingContext.response();
        if (productID == null) {
            sendError(400, response);
        } else {
            JsonObject product = routingContext.getBodyAsJson();
            if (product == null) {
                sendError(400, response);
            } else {
                products.put(productID, product);
                response.end();
            }
        }
    }

    private void handleListProducts(RoutingContext routingContext) {
        JsonArray arr = new JsonArray();
        products.forEach((k, v) -> arr.add(v));
        routingContext.response().putHeader("content-type", "application/json").end(arr.encodePrettily());
    }

    private void sendError(int statusCode, HttpServerResponse response) {
        response.setStatusCode(statusCode).end();
    }

    private void setUpInitialData() {
        addProduct(new JsonObject().put("id", "prod111").put("name", "AAAAA").put("price", 5.99).put("weight", 170));
        addProduct(new JsonObject().put("id", "prod222").put("name", "BBBB").put("price", 4.99).put("weight", 90));
        addProduct(new JsonObject().put("id", "prod333").put("name", "CCC").put("price", 3.00).put("weight", 70));
    }

    private void addProduct(JsonObject product) {
        products.put(product.getString("id"), product);
    }
}
