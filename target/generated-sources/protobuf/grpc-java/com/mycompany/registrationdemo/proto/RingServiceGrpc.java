package com.mycompany.registrationdemo.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * ===== Ring (node-to-node LCR and neighbor rewiring) =====
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: registrationdemo.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RingServiceGrpc {

  private RingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "registrationdemo.RingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.mycompany.registrationdemo.proto.ElectionMsg,
      com.google.protobuf.Empty> getElectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Election",
      requestType = com.mycompany.registrationdemo.proto.ElectionMsg.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.registrationdemo.proto.ElectionMsg,
      com.google.protobuf.Empty> getElectionMethod() {
    io.grpc.MethodDescriptor<com.mycompany.registrationdemo.proto.ElectionMsg, com.google.protobuf.Empty> getElectionMethod;
    if ((getElectionMethod = RingServiceGrpc.getElectionMethod) == null) {
      synchronized (RingServiceGrpc.class) {
        if ((getElectionMethod = RingServiceGrpc.getElectionMethod) == null) {
          RingServiceGrpc.getElectionMethod = getElectionMethod =
              io.grpc.MethodDescriptor.<com.mycompany.registrationdemo.proto.ElectionMsg, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Election"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.registrationdemo.proto.ElectionMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RingServiceMethodDescriptorSupplier("Election"))
              .build();
        }
      }
    }
    return getElectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mycompany.registrationdemo.proto.LeaderMsg,
      com.google.protobuf.Empty> getLeaderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Leader",
      requestType = com.mycompany.registrationdemo.proto.LeaderMsg.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.registrationdemo.proto.LeaderMsg,
      com.google.protobuf.Empty> getLeaderMethod() {
    io.grpc.MethodDescriptor<com.mycompany.registrationdemo.proto.LeaderMsg, com.google.protobuf.Empty> getLeaderMethod;
    if ((getLeaderMethod = RingServiceGrpc.getLeaderMethod) == null) {
      synchronized (RingServiceGrpc.class) {
        if ((getLeaderMethod = RingServiceGrpc.getLeaderMethod) == null) {
          RingServiceGrpc.getLeaderMethod = getLeaderMethod =
              io.grpc.MethodDescriptor.<com.mycompany.registrationdemo.proto.LeaderMsg, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Leader"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.registrationdemo.proto.LeaderMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RingServiceMethodDescriptorSupplier("Leader"))
              .build();
        }
      }
    }
    return getLeaderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mycompany.registrationdemo.proto.Neighbor,
      com.google.protobuf.Empty> getUpdateSuccessorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSuccessor",
      requestType = com.mycompany.registrationdemo.proto.Neighbor.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.registrationdemo.proto.Neighbor,
      com.google.protobuf.Empty> getUpdateSuccessorMethod() {
    io.grpc.MethodDescriptor<com.mycompany.registrationdemo.proto.Neighbor, com.google.protobuf.Empty> getUpdateSuccessorMethod;
    if ((getUpdateSuccessorMethod = RingServiceGrpc.getUpdateSuccessorMethod) == null) {
      synchronized (RingServiceGrpc.class) {
        if ((getUpdateSuccessorMethod = RingServiceGrpc.getUpdateSuccessorMethod) == null) {
          RingServiceGrpc.getUpdateSuccessorMethod = getUpdateSuccessorMethod =
              io.grpc.MethodDescriptor.<com.mycompany.registrationdemo.proto.Neighbor, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSuccessor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.registrationdemo.proto.Neighbor.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RingServiceMethodDescriptorSupplier("UpdateSuccessor"))
              .build();
        }
      }
    }
    return getUpdateSuccessorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RingServiceStub>() {
        @java.lang.Override
        public RingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RingServiceStub(channel, callOptions);
        }
      };
    return RingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RingServiceBlockingStub>() {
        @java.lang.Override
        public RingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RingServiceBlockingStub(channel, callOptions);
        }
      };
    return RingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RingServiceFutureStub>() {
        @java.lang.Override
        public RingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RingServiceFutureStub(channel, callOptions);
        }
      };
    return RingServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * ===== Ring (node-to-node LCR and neighbor rewiring) =====
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void election(com.mycompany.registrationdemo.proto.ElectionMsg request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getElectionMethod(), responseObserver);
    }

    /**
     */
    default void leader(com.mycompany.registrationdemo.proto.LeaderMsg request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLeaderMethod(), responseObserver);
    }

    /**
     */
    default void updateSuccessor(com.mycompany.registrationdemo.proto.Neighbor request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateSuccessorMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RingService.
   * <pre>
   * ===== Ring (node-to-node LCR and neighbor rewiring) =====
   * </pre>
   */
  public static abstract class RingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RingService.
   * <pre>
   * ===== Ring (node-to-node LCR and neighbor rewiring) =====
   * </pre>
   */
  public static final class RingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RingServiceStub> {
    private RingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RingServiceStub(channel, callOptions);
    }

    /**
     */
    public void election(com.mycompany.registrationdemo.proto.ElectionMsg request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getElectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void leader(com.mycompany.registrationdemo.proto.LeaderMsg request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLeaderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateSuccessor(com.mycompany.registrationdemo.proto.Neighbor request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSuccessorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RingService.
   * <pre>
   * ===== Ring (node-to-node LCR and neighbor rewiring) =====
   * </pre>
   */
  public static final class RingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RingServiceBlockingStub> {
    private RingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty election(com.mycompany.registrationdemo.proto.ElectionMsg request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getElectionMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty leader(com.mycompany.registrationdemo.proto.LeaderMsg request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLeaderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty updateSuccessor(com.mycompany.registrationdemo.proto.Neighbor request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSuccessorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RingService.
   * <pre>
   * ===== Ring (node-to-node LCR and neighbor rewiring) =====
   * </pre>
   */
  public static final class RingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RingServiceFutureStub> {
    private RingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> election(
        com.mycompany.registrationdemo.proto.ElectionMsg request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getElectionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> leader(
        com.mycompany.registrationdemo.proto.LeaderMsg request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLeaderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> updateSuccessor(
        com.mycompany.registrationdemo.proto.Neighbor request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSuccessorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ELECTION = 0;
  private static final int METHODID_LEADER = 1;
  private static final int METHODID_UPDATE_SUCCESSOR = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ELECTION:
          serviceImpl.election((com.mycompany.registrationdemo.proto.ElectionMsg) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LEADER:
          serviceImpl.leader((com.mycompany.registrationdemo.proto.LeaderMsg) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_SUCCESSOR:
          serviceImpl.updateSuccessor((com.mycompany.registrationdemo.proto.Neighbor) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getElectionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.registrationdemo.proto.ElectionMsg,
              com.google.protobuf.Empty>(
                service, METHODID_ELECTION)))
        .addMethod(
          getLeaderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.registrationdemo.proto.LeaderMsg,
              com.google.protobuf.Empty>(
                service, METHODID_LEADER)))
        .addMethod(
          getUpdateSuccessorMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.registrationdemo.proto.Neighbor,
              com.google.protobuf.Empty>(
                service, METHODID_UPDATE_SUCCESSOR)))
        .build();
  }

  private static abstract class RingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mycompany.registrationdemo.proto.Registrationdemo.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RingService");
    }
  }

  private static final class RingServiceFileDescriptorSupplier
      extends RingServiceBaseDescriptorSupplier {
    RingServiceFileDescriptorSupplier() {}
  }

  private static final class RingServiceMethodDescriptorSupplier
      extends RingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RingServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RingServiceFileDescriptorSupplier())
              .addMethod(getElectionMethod())
              .addMethod(getLeaderMethod())
              .addMethod(getUpdateSuccessorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
