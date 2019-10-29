import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class HelloWorldClient {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HelloWorldClient.class);

    private HelloWorldServiceGrpc.HelloWorldServiceBlockingStub helloWorldServiceBlockingStub;

    private HelloWorldServiceGrpc.HelloWorldServiceStub helloWorldServiceStub;
    //private HelloWorldServiceGrpc.HelloWorldServiceFutureStub helloWorldServiceFutureStub;
    public HelloWorldClient (){
        init();
    }
    //@PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 8080).usePlaintext().build();
       // MAX_SIZE = 50 *1024*1024;
        helloWorldServiceBlockingStub =
                HelloWorldServiceGrpc.newBlockingStub(managedChannel);
//        helloWorldServiceFutureStub =
//                HelloWorldServiceGrpc.newFutureStub(managedChannel);
    }

    public String sayHello(String firstName, String lastName) {
        Person person = Person.newBuilder().setFirstName(firstName)
                .setLastName(lastName).build();
        LOGGER.info("client sending {}", person);
        //helloWorldServiceStub.sayHello();
        Greeting greeting =
                helloWorldServiceBlockingStub.sayHello(person);
//        ListenableFuture<Greeting> greeting =
//        helloWorldServiceFutureStub.sayHello(person);
        LOGGER.info("client received {}", greeting);

        return greeting.getMessage();
    }
}
