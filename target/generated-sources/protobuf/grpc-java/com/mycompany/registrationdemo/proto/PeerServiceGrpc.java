package com.mycompany.RegistrationDemo.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: registrationdemo.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PeerServiceGrpc {

  private PeerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.mycompany.RegistrationDemo.proto.PeerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.Empty,
      com.mycompany.RegistrationDemo.proto.Empty> getPingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Ping",
      requestType = com.mycompany.RegistrationDemo.proto.Empty.class,
      responseType = com.mycompany.RegistrationDemo.proto.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.Empty,
      com.mycompany.RegistrationDemo.proto.Empty> getPingMethod() {
    io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.Empty, com.mycompany.RegistrationDemo.proto.Empty> getPingMethod;
    if ((getPingMethod = PeerServiceGrpc.getPingMethod) == null) {
      synchronized (PeerServiceGrpc.class) {
        if ((getPingMethod = PeerServiceGrpc.getPingMethod) == null) {
          PeerServiceGrpc.getPingMethod = getPingMethod =
              io.grpc.MethodDescriptor.<com.mycompany.RegistrationDemo.proto.Empty, com.mycompany.RegistrationDemo.proto.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Ping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.RegistrationDemo.proto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.RegistrationDemo.proto.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PeerServiceMethodDescriptorSupplier("Ping"))
              .build();
        }
      }
    }
    return getPingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.LookupRequest,
      com.mycompany.RegistrationDemo.proto.SuccessorReply> getGetSuccessorForMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSuccessorFor",
      requestType = com.mycompany.RegistrationDemo.proto.LookupRequest.class,
      responseType = com.mycompany.RegistrationDemo.proto.SuccessorReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.LookupRequest,
      com.mycompany.RegistrationDemo.proto.SuccessorReply> getGetSuccessorForMethod() {
    io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.LookupRequest, com.mycompany.RegistrationDemo.proto.SuccessorReply> getGetSuccessorForMethod;
    if ((getGetSuccessorForMethod = PeerServiceGrpc.getGetSuccessorForMethod) == null) {
      synchronized (PeerServiceGrpc.class) {
        if ((getGetSuccessorForMethod = PeerServiceGrpc.getGetSuccessorForMethod) == null) {
          PeerServiceGrpc.getGetSuccessorForMethod = getGetSuccessorForMethod =
              io.grpc.MethodDescriptor.<com.mycompany.RegistrationDemo.proto.LookupRequest, com.mycompany.RegistrationDemo.proto.SuccessorReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSuccessorFor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.RegistrationDemo.proto.LookupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.RegistrationDemo.proto.SuccessorReply.getDefaultInstance()))
              .setSchemaDescriptor(new PeerServiceMethodDescriptorSupplier("GetSuccessorFor"))
              .build();
        }
      }
    }
    return getGetSuccessorForMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.BootToken,
      com.mycompany.RegistrationDemo.proto.Empty> getBootstrapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Bootstrap",
      requestType = com.mycompany.RegistrationDemo.proto.BootToken.class,
      responseType = com.mycompany.RegistrationDemo.proto.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.BootToken,
      com.mycompany.RegistrationDemo.proto.Empty> getBootstrapMethod() {
    io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.BootToken, com.mycompany.RegistrationDemo.proto.Empty> getBootstrapMethod;
    if ((getBootstrapMethod = PeerServiceGrpc.getBootstrapMethod) == null) {
      synchronized (PeerServiceGrpc.class) {
        if ((getBootstrapMethod = PeerServiceGrpc.getBootstrapMethod) == null) {
          PeerServiceGrpc.getBootstrapMethod = getBootstrapMethod =
              io.grpc.MethodDescriptor.<com.mycompany.RegistrationDemo.proto.BootToken, com.mycompany.RegistrationDemo.proto.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Bootstrap"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.RegistrationDemo.proto.BootToken.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.RegistrationDemo.proto.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PeerServiceMethodDescriptorSupplier("Bootstrap"))
              .build();
        }
      }
    }
    return getBootstrapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.ElectionMsg,
      com.mycompany.RegistrationDemo.proto.Empty> getElectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Election",
      requestType = com.mycompany.RegistrationDemo.proto.ElectionMsg.class,
      responseType = com.mycompany.RegistrationDemo.proto.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.ElectionMsg,
      com.mycompany.RegistrationDemo.proto.Empty> getElectionMethod() {
    io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.ElectionMsg, com.mycompany.RegistrationDemo.proto.Empty> getElectionMethod;
    if ((getElectionMethod = PeerServiceGrpc.getElectionMethod) == null) {
      synchronized (PeerServiceGrpc.class) {
        if ((getElectionMethod = PeerServiceGrpc.getElectionMethod) == null) {
          PeerServiceGrpc.getElectionMethod = getElectionMethod =
              io.grpc.MethodDescriptor.<com.mycompany.RegistrationDemo.proto.ElectionMsg, com.mycompany.RegistrationDemo.proto.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Election"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.RegistrationDemo.proto.ElectionMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.RegistrationDemo.proto.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PeerServiceMethodDescriptorSupplier("Election"))
              .build();
        }
      }
    }
    return getElectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.CoordinatorMsg,
      com.mycompany.RegistrationDemo.proto.Empty> getCoordinatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Coordinator",
      requestType = com.mycompany.RegistrationDemo.proto.CoordinatorMsg.class,
      responseType = com.mycompany.RegistrationDemo.proto.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.CoordinatorMsg,
      com.mycompany.RegistrationDemo.proto.Empty> getCoordinatorMethod() {
    io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.CoordinatorMsg, com.mycompany.RegistrationDemo.proto.Empty> getCoordinatorMethod;
    if ((getCoordinatorMethod = PeerServiceGrpc.getCoordinatorMethod) == null) {
      synchronized (PeerServiceGrpc.class) {
        if ((getCoordinatorMethod = PeerServiceGrpc.getCoordinatorMethod) == null) {
          PeerServiceGrpc.getCoordinatorMethod = getCoordinatorMethod =
              io.grpc.MethodDescriptor.<com.mycompany.RegistrationDemo.proto.CoordinatorMsg, com.mycompany.RegistrationDemo.proto.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Coordinator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.RegistrationDemo.proto.CoordinatorMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.RegistrationDemo.proto.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PeerServiceMethodDescriptorSupplier("Coordinator"))
              .build();
        }
      }
    }
    return getCoordinatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.Empty,
      com.mycompany.RegistrationDemo.proto.PeerListReply> getPeerListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PeerList",
      requestType = com.mycompany.RegistrationDemo.proto.Empty.class,
      responseType = com.mycompany.RegistrationDemo.proto.PeerListReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.Empty,
      com.mycompany.RegistrationDemo.proto.PeerListReply> getPeerListMethod() {
    io.grpc.MethodDescriptor<com.mycompany.RegistrationDemo.proto.Empty, com.mycompany.RegistrationDemo.proto.PeerListReply> getPeerListMethod;
    if ((getPeerListMethod = PeerServiceGrpc.getPeerListMethod) == null) {
      synchronized (PeerServiceGrpc.class) {
        if ((getPeerListMethod = PeerServiceGrpc.getPeerListMethod) == null) {
          PeerServiceGrpc.getPeerListMethod = getPeerListMethod =
              io.grpc.MethodDescriptor.<com.mycompany.RegistrationDemo.proto.Empty, com.mycompany.RegistrationDemo.proto.PeerListReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PeerList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.RegistrationDemo.proto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.RegistrationDemo.proto.PeerListReply.getDefaultInstance()))
              .setSchemaDescriptor(new PeerServiceMethodDescriptorSupplier("PeerList"))
              .build();
        }
      }
    }
    return getPeerListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PeerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PeerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PeerServiceStub>() {
        @java.lang.Override
        public PeerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PeerServiceStub(channel, callOptions);
        }
      };
    return PeerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PeerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PeerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PeerServiceBlockingStub>() {
        @java.lang.Override
        public PeerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PeerServiceBlockingStub(channel, callOptions);
        }
      };
    return PeerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PeerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PeerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PeerServiceFutureStub>() {
        @java.lang.Override
        public PeerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PeerServiceFutureStub(channel, callOptions);
        }
      };
    return PeerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void ping(com.mycompany.RegistrationDemo.proto.Empty request,
        io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPingMethod(), responseObserver);
    }

    /**
     */
    default void getSuccessorFor(com.mycompany.RegistrationDemo.proto.LookupRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.SuccessorReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSuccessorForMethod(), responseObserver);
    }

    /**
     * <pre>
     * Ring bootstrap: circulate once around the ring before elections
     * </pre>
     */
    default void bootstrap(com.mycompany.RegistrationDemo.proto.BootToken request,
        io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBootstrapMethod(), responseObserver);
    }

    /**
     * <pre>
     * Election (Chang–Roberts)
     * </pre>
     */
    default void election(com.mycompany.RegistrationDemo.proto.ElectionMsg request,
        io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getElectionMethod(), responseObserver);
    }

    /**
     */
    default void coordinator(com.mycompany.RegistrationDemo.proto.CoordinatorMsg request,
        io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCoordinatorMethod(), responseObserver);
    }

    /**
     * <pre>
     * Peer exchange
     * </pre>
     */
    default void peerList(com.mycompany.RegistrationDemo.proto.Empty request,
        io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.PeerListReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPeerListMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PeerService.
   */
  public static abstract class PeerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PeerServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PeerService.
   */
  public static final class PeerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PeerServiceStub> {
    private PeerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PeerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PeerServiceStub(channel, callOptions);
    }

    /**
     */
    public void ping(com.mycompany.RegistrationDemo.proto.Empty request,
        io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSuccessorFor(com.mycompany.RegistrationDemo.proto.LookupRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.SuccessorReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSuccessorForMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Ring bootstrap: circulate once around the ring before elections
     * </pre>
     */
    public void bootstrap(com.mycompany.RegistrationDemo.proto.BootToken request,
        io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBootstrapMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Election (Chang–Roberts)
     * </pre>
     */
    public void election(com.mycompany.RegistrationDemo.proto.ElectionMsg request,
        io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getElectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void coordinator(com.mycompany.RegistrationDemo.proto.CoordinatorMsg request,
        io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCoordinatorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Peer exchange
     * </pre>
     */
    public void peerList(com.mycompany.RegistrationDemo.proto.Empty request,
        io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.PeerListReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPeerListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PeerService.
   */
  public static final class PeerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PeerServiceBlockingStub> {
    private PeerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PeerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PeerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.mycompany.RegistrationDemo.proto.Empty ping(com.mycompany.RegistrationDemo.proto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPingMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mycompany.RegistrationDemo.proto.SuccessorReply getSuccessorFor(com.mycompany.RegistrationDemo.proto.LookupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSuccessorForMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Ring bootstrap: circulate once around the ring before elections
     * </pre>
     */
    public com.mycompany.RegistrationDemo.proto.Empty bootstrap(com.mycompany.RegistrationDemo.proto.BootToken request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBootstrapMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Election (Chang–Roberts)
     * </pre>
     */
    public com.mycompany.RegistrationDemo.proto.Empty election(com.mycompany.RegistrationDemo.proto.ElectionMsg request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getElectionMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mycompany.RegistrationDemo.proto.Empty coordinator(com.mycompany.RegistrationDemo.proto.CoordinatorMsg request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCoordinatorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Peer exchange
     * </pre>
     */
    public com.mycompany.RegistrationDemo.proto.PeerListReply peerList(com.mycompany.RegistrationDemo.proto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPeerListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PeerService.
   */
  public static final class PeerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PeerServiceFutureStub> {
    private PeerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PeerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PeerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.RegistrationDemo.proto.Empty> ping(
        com.mycompany.RegistrationDemo.proto.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.RegistrationDemo.proto.SuccessorReply> getSuccessorFor(
        com.mycompany.RegistrationDemo.proto.LookupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSuccessorForMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Ring bootstrap: circulate once around the ring before elections
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.RegistrationDemo.proto.Empty> bootstrap(
        com.mycompany.RegistrationDemo.proto.BootToken request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBootstrapMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Election (Chang–Roberts)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.RegistrationDemo.proto.Empty> election(
        com.mycompany.RegistrationDemo.proto.ElectionMsg request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getElectionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.RegistrationDemo.proto.Empty> coordinator(
        com.mycompany.RegistrationDemo.proto.CoordinatorMsg request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCoordinatorMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Peer exchange
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.RegistrationDemo.proto.PeerListReply> peerList(
        com.mycompany.RegistrationDemo.proto.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPeerListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PING = 0;
  private static final int METHODID_GET_SUCCESSOR_FOR = 1;
  private static final int METHODID_BOOTSTRAP = 2;
  private static final int METHODID_ELECTION = 3;
  private static final int METHODID_COORDINATOR = 4;
  private static final int METHODID_PEER_LIST = 5;

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
        case METHODID_PING:
          serviceImpl.ping((com.mycompany.RegistrationDemo.proto.Empty) request,
              (io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.Empty>) responseObserver);
          break;
        case METHODID_GET_SUCCESSOR_FOR:
          serviceImpl.getSuccessorFor((com.mycompany.RegistrationDemo.proto.LookupRequest) request,
              (io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.SuccessorReply>) responseObserver);
          break;
        case METHODID_BOOTSTRAP:
          serviceImpl.bootstrap((com.mycompany.RegistrationDemo.proto.BootToken) request,
              (io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.Empty>) responseObserver);
          break;
        case METHODID_ELECTION:
          serviceImpl.election((com.mycompany.RegistrationDemo.proto.ElectionMsg) request,
              (io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.Empty>) responseObserver);
          break;
        case METHODID_COORDINATOR:
          serviceImpl.coordinator((com.mycompany.RegistrationDemo.proto.CoordinatorMsg) request,
              (io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.Empty>) responseObserver);
          break;
        case METHODID_PEER_LIST:
          serviceImpl.peerList((com.mycompany.RegistrationDemo.proto.Empty) request,
              (io.grpc.stub.StreamObserver<com.mycompany.RegistrationDemo.proto.PeerListReply>) responseObserver);
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
          getPingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.RegistrationDemo.proto.Empty,
              com.mycompany.RegistrationDemo.proto.Empty>(
                service, METHODID_PING)))
        .addMethod(
          getGetSuccessorForMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.RegistrationDemo.proto.LookupRequest,
              com.mycompany.RegistrationDemo.proto.SuccessorReply>(
                service, METHODID_GET_SUCCESSOR_FOR)))
        .addMethod(
          getBootstrapMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.RegistrationDemo.proto.BootToken,
              com.mycompany.RegistrationDemo.proto.Empty>(
                service, METHODID_BOOTSTRAP)))
        .addMethod(
          getElectionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.RegistrationDemo.proto.ElectionMsg,
              com.mycompany.RegistrationDemo.proto.Empty>(
                service, METHODID_ELECTION)))
        .addMethod(
          getCoordinatorMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.RegistrationDemo.proto.CoordinatorMsg,
              com.mycompany.RegistrationDemo.proto.Empty>(
                service, METHODID_COORDINATOR)))
        .addMethod(
          getPeerListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.mycompany.RegistrationDemo.proto.Empty,
              com.mycompany.RegistrationDemo.proto.PeerListReply>(
                service, METHODID_PEER_LIST)))
        .build();
  }

  private static abstract class PeerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PeerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mycompany.RegistrationDemo.proto.RegistrationDemoProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PeerService");
    }
  }

  private static final class PeerServiceFileDescriptorSupplier
      extends PeerServiceBaseDescriptorSupplier {
    PeerServiceFileDescriptorSupplier() {}
  }

  private static final class PeerServiceMethodDescriptorSupplier
      extends PeerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PeerServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PeerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PeerServiceFileDescriptorSupplier())
              .addMethod(getPingMethod())
              .addMethod(getGetSuccessorForMethod())
              .addMethod(getBootstrapMethod())
              .addMethod(getElectionMethod())
              .addMethod(getCoordinatorMethod())
              .addMethod(getPeerListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
