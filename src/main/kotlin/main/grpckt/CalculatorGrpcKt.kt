import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls
import io.grpc.kotlin.ClientCalls.bidiStreamingRpc
import io.grpc.kotlin.ClientCalls.clientStreamingRpc
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls
import io.grpc.kotlin.ServerCalls.bidiStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.clientStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.serverStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow

/**
 * Holder for Kotlin coroutine-based client and server APIs for CalculatorService.
 */
object CalculatorServiceGrpcKt {
  const val SERVICE_NAME: String = CalculatorServiceGrpc.SERVICE_NAME

  @JvmStatic
  val serviceDescriptor: ServiceDescriptor
    get() = CalculatorServiceGrpc.getServiceDescriptor()

  val addMethod: MethodDescriptor<AddRequest, AddResponse>
    @JvmStatic
    get() = CalculatorServiceGrpc.getAddMethod()

  val sumMethod: MethodDescriptor<SumRequest, SumResponse>
    @JvmStatic
    get() = CalculatorServiceGrpc.getSumMethod()

  val primeNumberDecompositionMethod: MethodDescriptor<PrimeNumberDecompositionRequest,
      PrimeNumberDecompositionResponse>
    @JvmStatic
    get() = CalculatorServiceGrpc.getPrimeNumberDecompositionMethod()

  val computeAverageMethod: MethodDescriptor<ComputeAverageRequest, ComputeAverageResponse>
    @JvmStatic
    get() = CalculatorServiceGrpc.getComputeAverageMethod()

  val findMaximumMethod: MethodDescriptor<FindMaximumRequest, FindMaximumResponse>
    @JvmStatic
    get() = CalculatorServiceGrpc.getFindMaximumMethod()

  /**
   * A stub for issuing RPCs to a(n) CalculatorService service as suspending coroutines.
   */
  @StubFor(CalculatorServiceGrpc::class)
  class CalculatorServiceCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT
  ) : AbstractCoroutineStub<CalculatorServiceCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): CalculatorServiceCoroutineStub =
        CalculatorServiceCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun add(request: AddRequest, headers: Metadata = Metadata()): AddResponse = unaryRpc(
      channel,
      CalculatorServiceGrpc.getAddMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun sum(request: SumRequest, headers: Metadata = Metadata()): SumResponse = unaryRpc(
      channel,
      CalculatorServiceGrpc.getSumMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    fun primeNumberDecomposition(request: PrimeNumberDecompositionRequest, headers: Metadata =
        Metadata()): Flow<PrimeNumberDecompositionResponse> = serverStreamingRpc(
      channel,
      CalculatorServiceGrpc.getPrimeNumberDecompositionMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * This function collects the [Flow] of requests.  If the server terminates the RPC
     * for any reason before collection of requests is complete, the collection of requests
     * will be cancelled.  If the collection of requests completes exceptionally for any other
     * reason, the RPC will be cancelled for that reason and this method will throw that
     * exception.
     *
     * @param requests A [Flow] of request messages.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun computeAverage(requests: Flow<ComputeAverageRequest>, headers: Metadata =
        Metadata()): ComputeAverageResponse = clientStreamingRpc(
      channel,
      CalculatorServiceGrpc.getComputeAverageMethod(),
      requests,
      callOptions,
      headers
    )
    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * The [Flow] of requests is collected once each time the [Flow] of responses is
     * collected. If collection of the [Flow] of responses completes normally or
     * exceptionally before collection of `requests` completes, the collection of
     * `requests` is cancelled.  If the collection of `requests` completes
     * exceptionally for any other reason, then the collection of the [Flow] of responses
     * completes exceptionally for the same reason and the RPC is cancelled with that reason.
     *
     * @param requests A [Flow] of request messages.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    fun findMaximum(requests: Flow<FindMaximumRequest>, headers: Metadata = Metadata()):
        Flow<FindMaximumResponse> = bidiStreamingRpc(
      channel,
      CalculatorServiceGrpc.getFindMaximumMethod(),
      requests,
      callOptions,
      headers
    )}

  /**
   * Skeletal implementation of the CalculatorService service based on Kotlin coroutines.
   */
  abstract class CalculatorServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for CalculatorService.Add.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun add(request: AddRequest): AddResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method CalculatorService.Add is unimplemented"))

    /**
     * Returns the response to an RPC for CalculatorService.Sum.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun sum(request: SumRequest): SumResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method CalculatorService.Sum is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for CalculatorService.PrimeNumberDecomposition.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open fun primeNumberDecomposition(request: PrimeNumberDecompositionRequest):
        Flow<PrimeNumberDecompositionResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method CalculatorService.PrimeNumberDecomposition is unimplemented"))

    /**
     * Returns the response to an RPC for CalculatorService.ComputeAverage.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    open suspend fun computeAverage(requests: Flow<ComputeAverageRequest>): ComputeAverageResponse =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method CalculatorService.ComputeAverage is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for CalculatorService.FindMaximum.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    open fun findMaximum(requests: Flow<FindMaximumRequest>): Flow<FindMaximumResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method CalculatorService.FindMaximum is unimplemented"))

    final override fun bindService(): ServerServiceDefinition =
        builder(CalculatorServiceGrpc.getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CalculatorServiceGrpc.getAddMethod(),
      implementation = ::add
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CalculatorServiceGrpc.getSumMethod(),
      implementation = ::sum
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CalculatorServiceGrpc.getPrimeNumberDecompositionMethod(),
      implementation = ::primeNumberDecomposition
    ))
      .addMethod(clientStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CalculatorServiceGrpc.getComputeAverageMethod(),
      implementation = ::computeAverage
    ))
      .addMethod(bidiStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CalculatorServiceGrpc.getFindMaximumMethod(),
      implementation = ::findMaximum
    )).build()
  }
}
