//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: calculator.proto

@kotlin.jvm.JvmName("-initializecomputeAverageResponse")
public inline fun computeAverageResponse(block: ComputeAverageResponseKt.Dsl.() -> kotlin.Unit): ComputeAverageResponse =
  ComputeAverageResponseKt.Dsl._create(ComputeAverageResponse.newBuilder()).apply { block() }._build()
public object ComputeAverageResponseKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: ComputeAverageResponse.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ComputeAverageResponse.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ComputeAverageResponse = _builder.build()

    /**
     * <code>double average = 1;</code>
     */
    public var average: kotlin.Double
      @JvmName("getAverage")
      get() = _builder.getAverage()
      @JvmName("setAverage")
      set(value) {
        _builder.setAverage(value)
      }
    /**
     * <code>double average = 1;</code>
     */
    public fun clearAverage() {
      _builder.clearAverage()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun ComputeAverageResponse.copy(block: ComputeAverageResponseKt.Dsl.() -> kotlin.Unit): ComputeAverageResponse =
  ComputeAverageResponseKt.Dsl._create(this.toBuilder()).apply { block() }._build()
