package dev.razshare.result

import java.util.Optional

class Result<T>(val value: Optional<T>, val error: Optional<Error>) {
    fun unwrap(): Pair<T, Optional<Error>> {
        if(value.isPresent) {
            return Pair(value.get(), error)
        }
        @Suppress("UNREACHABLE_CODE")
        return Pair(null!!, error)
    }

    /**
     * @throws NoSuchElementException if no value is present
     */
    fun attempt(): T {
        if (error.isPresent) {
            throw error.get()
        }
        
        return value.get()
    }
}