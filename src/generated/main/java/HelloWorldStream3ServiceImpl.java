import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class HelloWorldStream3ServiceImpl extends HelloWorldStream3ServiceGrpc.HelloWorldStream3ServiceImplBase {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HelloWorldStream3ServiceImpl.class);

    @Override
    public StreamObserver<Person> sayHello(StreamObserver<Greeting> responseObserver) {
        //LOGGER.info("server received {}", request);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext(true).build();
        HelloWorldStream3ServiceGrpc.HelloWorldStream3ServiceStub stub = HelloWorldStream3ServiceGrpc.newStub(channel);
        StreamObserver<Person> requestStream = stub.sayHello(responseObserver);

        String message = "Hello " /*+ request.getFirstName() + " "
                + request.getLastName() + "!"*/;
        Greeting greeting =
                Greeting.newBuilder().setMessage(message).build();
        LOGGER.info("server responded {}", greeting);

        responseObserver.onNext(greeting);
        responseObserver.onCompleted();
        return requestStream;
    }
}
