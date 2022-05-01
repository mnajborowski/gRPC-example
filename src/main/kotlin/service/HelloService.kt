package service

import HelloReply
import HelloRequest

class HelloService : HelloServiceGrpcKt.HelloServiceCoroutineImplBase() {
    override suspend fun hello(request: HelloRequest): HelloReply {
        return HelloReply.newBuilder()
            .setMessage("Hello, ${request.name}")
            .build()
    }
}