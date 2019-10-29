import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: cars.proto")
public final class HelloWorldStream3ServiceGrpc {

  private HelloWorldStream3ServiceGrpc() {}

  public static final String SERVICE_NAME = "HelloWorldStream3Service";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Person,
      Greeting> METHOD_SAY_HELLO =
      io.grpc.MethodDescriptor.<Person, Greeting>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "HelloWorldStream3Service", "sayHello"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Person.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              Greeting.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloWorldStream3ServiceStub newStub(io.grpc.Channel channel) {
    return new HelloWorldStream3ServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloWorldStream3ServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HelloWorldStream3ServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloWorldStream3ServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HelloWorldStream3ServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HelloWorldStream3ServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<Person> sayHello(
        io.grpc.stub.StreamObserver<Greeting> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_SAY_HELLO, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SAY_HELLO,
            asyncClientStreamingCall(
              new MethodHandlers<
                Person,
                Greeting>(
                  this, METHODID_SAY_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class HelloWorldStream3ServiceStub extends io.grpc.stub.AbstractStub<HelloWorldStream3ServiceStub> {
    private HelloWorldStream3ServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloWorldStream3ServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldStream3ServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloWorldStream3ServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Person> sayHello(
        io.grpc.stub.StreamObserver<Greeting> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_SAY_HELLO, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class HelloWorldStream3ServiceBlockingStub extends io.grpc.stub.AbstractStub<HelloWorldStream3ServiceBlockingStub> {
    private HelloWorldStream3ServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloWorldStream3ServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldStream3ServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloWorldStream3ServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class HelloWorldStream3ServiceFutureStub extends io.grpc.stub.AbstractStub<HelloWorldStream3ServiceFutureStub> {
    private HelloWorldStream3ServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloWorldStream3ServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldStream3ServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloWorldStream3ServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloWorldStream3ServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HelloWorldStream3ServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sayHello(
              (io.grpc.stub.StreamObserver<Greeting>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class HelloWorldStream3ServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Cars.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HelloWorldStream3ServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloWorldStream3ServiceDescriptorSupplier())
              .addMethod(METHOD_SAY_HELLO)
              .build();
        }
      }
    }
    return result;
  }
}
