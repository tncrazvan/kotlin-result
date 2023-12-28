fun<T> ok(value: T): Maybe<T> {
    return Maybe(value, false, "")
}

fun<T:Any> error(message: String): Maybe<T> {
    return Maybe(null, true, message)
}