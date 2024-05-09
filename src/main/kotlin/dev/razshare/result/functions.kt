package dev.razshare.result

import java.util.*

fun<T : Any> success(value: T): Result<T> {
    return Result(Optional.of(value), Optional.empty())
}

fun<T : Any> failure(error: String): Result<T> {
    return Result(Optional.empty(), Optional.of(Error(error)))
}

fun<T : Any> failure(error: Error): Result<T> {
    return Result(Optional.empty(), Optional.of(error))
}