# Kotlin Result

This is a simple standalone utility library for managing unsafe results in Kotlin instead of throwing exceptions.

```kt
import dev.razshare.result.Result
import dev.razshare.result.success
import dev.razshare.result.failure

data class User(val username: String, val password: String)

fun validateUser(user: User): Result<User> {
    if(user.password.length < 4){
        return failure("User password must be at least 4 characters, received ${user.password.length} characters.")
    }

    return success(user)
}

fun main(){
    val (user, error) = validateUser(User(username = "foo", password = "bar")).unwrap()

    if(error.isPresent){
        println(error.get)
        return
    }

    println("User ${user.username} is valid.")
}
```

# Using Gradle Kotlin

- Add the repository to your `build.gradle.kts`
  ```kt
  repositories {
      maven {
          url = uri("https://raw.githubusercontent.com/tncrazvan/artifacts/main")
          metadataSources {
              mavenPom()
              artifact()
              ignoreGradleMetadataRedirection()
          }
      }
  }
  ```

- Add the library to your `build.gradle.kts`, for example `dev.razshare.result`
  ```kt
  dependencies {
      implementation("dev.razshare:result:0.1.0")
  }
  ```

# Using Maven

- Add the repository to your `pom.xml`
  ```xml
  <repositories>
      <repository>
          <id>dev.razshare</id>
          <url>https://raw.githubusercontent.com/tncrazvan/artifacts/main</url>
      </repository>
  </repositories>
  ```

- Add the library to your `pom.xml`, for example `dev.razshare.result`
  ```xml
  <dependencies>
      <dependency>
          <groupId>dev.razshare</groupId>
          <artifactId>result</artifactId>
          <version>0.1.0</version>
          <type>jar</type>
      </dependency>
  </dependencies>
  ```
