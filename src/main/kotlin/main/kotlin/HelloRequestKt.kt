//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: hello_world.proto

@kotlin.jvm.JvmName("-initializehelloRequest")
public inline fun helloRequest(block: HelloRequestKt.Dsl.() -> kotlin.Unit): HelloRequest =
  HelloRequestKt.Dsl._create(HelloRequest.newBuilder()).apply { block() }._build()
public object HelloRequestKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: HelloRequest.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: HelloRequest.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): HelloRequest = _builder.build()

    /**
     * <code>string name = 1;</code>
     */
    public var name: kotlin.String
      @JvmName("getName")
      get() = _builder.getName()
      @JvmName("setName")
      set(value) {
        _builder.setName(value)
      }
    /**
     * <code>string name = 1;</code>
     */
    public fun clearName() {
      _builder.clearName()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun HelloRequest.copy(block: HelloRequestKt.Dsl.() -> kotlin.Unit): HelloRequest =
  HelloRequestKt.Dsl._create(this.toBuilder()).apply { block() }._build()

