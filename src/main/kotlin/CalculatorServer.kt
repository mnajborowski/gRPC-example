import io.grpc.ServerBuilder
import service.CalculatorService

fun main() {
    val server = ServerBuilder
        .forPort(15001)
        .addService(CalculatorService())
        .build()

    Runtime.getRuntime().addShutdownHook(Thread {
        server.shutdown()
        server.awaitTermination()
    })

    server.start()
    server.awaitTermination()
}