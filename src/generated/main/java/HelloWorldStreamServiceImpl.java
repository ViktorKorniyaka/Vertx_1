import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

public class HelloWorldStreamServiceImpl extends HelloWorldStreamServiceGrpc.HelloWorldStreamServiceImplBase {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HelloWorldStreamServiceImpl.class);

    @Override
    public StreamObserver<Person> sayHello(StreamObserver<Greeting> responseObserver) {
        //LOGGER.info("server received {}", request);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext(true).build();
        HelloWorldStreamServiceGrpc.HelloWorldStreamServiceStub stub = HelloWorldStreamServiceGrpc.newStub(channel);
        StreamObserver<Person> requestStream = stub.sayHello(responseObserver);


        String message = "Hello ";/* + request.getFirstName() + " "
                + request.getLastName() + "!";*/
        Greeting greeting =
                Greeting.newBuilder().setMessage(message).build();
        Person person = Person.newBuilder().setFirstName("firstName")
                .setLastName("lastName").build();
        LOGGER.info("server responded {}", requestStream);

        responseObserver.onNext(greeting); // ???
        responseObserver.onCompleted();
        return requestStream;
    }
}
