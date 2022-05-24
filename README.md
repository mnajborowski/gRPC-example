# gRPC-example

My side project for learning the basics of gRPC. As for the moment I implemented server-side application with two
services written in Kotlin:
- [HelloService](src/main/kotlin/service/HelloService.kt)
- [CalculatorService](src/main/kotlin/service/CalculatorService.kt)

**CalculatorService** provides functions using all the gRPC modes:
- unary
- server streaming
- client streaming
- bidirectional streaming

I test the application with Postman gRPC Client.