package com.codenotfound.grpc_server;

// import org.lognet.springboot.grpc.GRpcService;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import com.codenotfound.grpc.helloworld.Greeting;
// import com.codenotfound.grpc.helloworld.Sentence;
// import com.codenotfound.grpc.helloworld.HelloWorldServiceGrpc;
// import com.codenotfound.grpc.helloworld.Person;
// import io.grpc.stub.StreamObserver;

import com.codenotfound.grpc.lib.GreeterGrpc;
import com.codenotfound.grpc.lib.HelloWorld;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

@Slf4j
@GrpcService(HelloWorld.class)
public class GreeterService extends GreeterGrpc.GreeterImplBase {
  @Override
  public void getPalindrome(HelloWorld.HelloRequest request, StreamObserver<HelloWorld.HelloReply> responseObserver) {
      // Stack<String> stack = new Stack<>();
      // String[] words = request.getName().split(' ');
      String message = new StringBuilder(request.getName()).reverse().toString();
      final HelloWorld.HelloReply.Builder replyBuilder = HelloWorld.HelloReply.newBuilder().setMessage(message);
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
      log.info("Returning " +message);
  }
  @Override
  public void sayHello(HelloWorld.HelloRequest request, StreamObserver<HelloWorld.HelloReply> responseObserver) {
      String message = "Hello " + request.getName();
      final HelloWorld.HelloReply.Builder replyBuilder = HelloWorld.HelloReply.newBuilder().setMessage(message);
      responseObserver.onNext(replyBuilder.build());
      responseObserver.onCompleted();
      log.info("Returning " +message);
  }
}
/*
public class HelloWorldServiceImpl
    extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(HelloWorldServiceImpl.class);

  @Override
  public void sayHello(Person request,
      StreamObserver<Greeting> responseObserver) {
    LOGGER.info("server received {}", request);

    String message = "Hello " + request.getFirstName() + " "
        + request.getLastName() + "!";
    Greeting greeting =
        Greeting.newBuilder().setMessage(message).build();
    LOGGER.info("server responded {}", greeting);

    //return the Greeting
    responseObserver.onNext(greeting);
    //tell gRPC that we’ve finished writing responses
    responseObserver.onCompleted();
  }

  @Override
  public void palindrome(Sentence request,
      StreamObserver<Greeting> responseObserver) {
    LOGGER.info("server received {}", request);

    //System.out.println("DEBUG", request.getMessage().getClass());
    String message = new StringBuilder(request.getMessage()).reverse().toString();
    //"Hello " + request.getFirstName() + " " + request.getLastName() + "!";
    Greeting greeting =
        Greeting.newBuilder().setMessage(message).build();
    LOGGER.info("server responded {}", greeting);

    //return the Greeting
    responseObserver.onNext(greeting);
    //tell gRPC that we’ve finished writing responses
    responseObserver.onCompleted();
  }
}
*/