import io.grpc.ServerBuilder
import service.HelloService

fun main() {
    val helloService = HelloService()
    val server = ServerBuilder
        .forPort(15001)
        .addService(helloService)
        .build()

    Runtime.getRuntime().addShutdownHook(Thread {
        server.shutdown()
        server.awaitTermination()
    })

    server.start()
    server.awaitTermination()
}