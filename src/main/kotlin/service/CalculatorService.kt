package service

import AddRequest
import AddResponse
import CalculatorServiceGrpcKt
import ComputeAverageRequest
import ComputeAverageResponse
import FindMaximumRequest
import FindMaximumResponse
import PrimeNumberDecompositionRequest
import PrimeNumberDecompositionResponse
import SumRequest
import SumResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CalculatorService : CalculatorServiceGrpcKt.CalculatorServiceCoroutineImplBase() {
    override suspend fun add(request: AddRequest): AddResponse {
        return AddResponse.newBuilder()
            .setResult(request.a + request.b)
            .build()
    }

    override suspend fun sum(request: SumRequest): SumResponse {
        return SumResponse.newBuilder()
            .setResult(request.xList.fold(0) { acc, e -> acc + e })
            .build()
    }

    override fun primeNumberDecomposition(request: PrimeNumberDecompositionRequest): Flow<PrimeNumberDecompositionResponse> {
        var k = 2L
        var n = request.number
        return flow {
            while (n > 1) {
                if ((n % k) == 0L) {
                    emit(PrimeNumberDecompositionResponse.newBuilder().setNumber(k).build())
                    n /= k
                } else
                    k++
            }
        }
    }

    override suspend fun computeAverage(requests: Flow<ComputeAverageRequest>): ComputeAverageResponse {
        var sum = 0
        var count = 0
        requests.collect { request ->
            sum += request.number
            count++
        }
        return ComputeAverageResponse.newBuilder().setAverage(sum.div(count.toDouble())).build()
    }

    override fun findMaximum(requests: Flow<FindMaximumRequest>): Flow<FindMaximumResponse> {
        var max = 0
        return flow {
            requests.collect { request ->
                if (request.number > max)
                    emit(FindMaximumResponse.newBuilder().setMaximum(request.number).build()).also {
                        max = request.number
                    }
            }
        }
    }
}