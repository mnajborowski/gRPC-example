//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: calculator.proto

@kotlin.jvm.JvmName("-initializecomputeAverageRequest")
public inline fun computeAverageRequest(block: ComputeAverageRequestKt.Dsl.() -> kotlin.Unit): ComputeAverageRequest =
  ComputeAverageRequestKt.Dsl._create(ComputeAverageRequest.newBuilder()).apply { block() }._build()
public object ComputeAverageRequestKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: ComputeAverageRequest.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ComputeAverageRequest.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ComputeAverageRequest = _builder.build()

    /**
     * <code>int32 number = 1;</code>
     */
    public var number: kotlin.Int
      @JvmName("getNumber")
      get() = _builder.getNumber()
      @JvmName("setNumber")
      set(value) {
        _builder.setNumber(value)
      }
    /**
     * <code>int32 number = 1;</code>
     */
    public fun clearNumber() {
      _builder.clearNumber()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun ComputeAverageRequest.copy(block: ComputeAverageRequestKt.Dsl.() -> kotlin.Unit): ComputeAverageRequest =
  ComputeAverageRequestKt.Dsl._create(this.toBuilder()).apply { block() }._build()

