package dev.razshare.unsafe

import java.util.Optional

data class Unsafe<T>(val value:Optional<T>, val error: Optional<Error>)