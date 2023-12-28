# Kotlin Unsafe

This is a simple standalone utility library for managing unsafe results in Kotlin instead of throwing exceptions.

```kt
import dev.razshare.Unsafe
import dev.razshare.ok
import dev.razshare.error

data class User(val username: String, val password: String)

fun validateUser(user: User): Unsafe<User> {
    if(user.password.length < 4){
        return error("User password must be at least 4 characters, received ${user.password.length} characters.")
    }

    return ok(user)
}

fun main(){
    val (user, error) = validateUser(User(username = "foo", password = "bar"))

    if(error.isPresent){
        println(error)
        return
    }

    println("User ${user.get().username} is valid.")
}
```