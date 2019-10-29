import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SecondMain {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext(true)
                .build();

        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub
                = HelloWorldServiceGrpc.newBlockingStub(channel);

        Greeting helloResponse = stub.sayHello(Person.newBuilder()
                .setFirstName("Baeldung")
                .setLastName("gRPC")
                .build());

        System.out.println("Response received from server:\n" + helloResponse);

        channel.shutdown();
    }
}
