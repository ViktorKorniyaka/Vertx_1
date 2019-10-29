import io.grpc.stub.StreamObserver;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class HelloWorldStream2ServiceImpl extends HelloWorldStream2ServiceGrpc.HelloWorldStream2ServiceImplBase {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HelloWorldStream2ServiceImpl.class);

    @Override
    public void sayHello(Person request, StreamObserver<Greeting> responseObserver) {
        LOGGER.info("server received {}", request);

        String message = "Hello " + request.getFirstName() + " "
                + request.getLastName() + "!";
        Greeting greeting =
                Greeting.newBuilder().setMessage(message).build();
        LOGGER.info("server responded {}", greeting);

        responseObserver.onNext(greeting);
        responseObserver.onCompleted();
    }
}
