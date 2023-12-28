import java.util.Optional

fun<T : Any> ok(value: T): Unsafe<T> {
    return Unsafe(Optional.of(value), Optional.empty())
}

fun<T : Any> error(message: String): Unsafe<T> {
    return Unsafe(Optional.empty(), Optional.of(Error(message)))
}