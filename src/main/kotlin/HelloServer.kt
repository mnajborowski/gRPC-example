import io.grpc.ServerBuilder
import service.HelloService

fun main() {
    val server = ServerBuilder
        .forPort(15001)
        .addService(HelloService())
        .build()

    Runtime.getRuntime().addShutdownHook(Thread {
        server.shutdown()
        server.awaitTermination()
    })

    server.start()
    server.awaitTermination()
}