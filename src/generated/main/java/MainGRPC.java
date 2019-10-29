import io.grpc.Server;
import io.grpc.ServerBuilder;

public class MainGRPC {

    public static void main(String[] arg) {
        try {
            Server server = ServerBuilder.forPort(8080)
                    .addService(new HelloWorldServiceImpl())
                    .build();
            server.start();
            System.out.println("Server has started ========");

            HelloWorldClient client = new HelloWorldClient();
            String str = client.sayHello("Viktor", "Korniiaka");
            str.length();
            server.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
