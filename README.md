# [Antaes](https://www.antaes.ch/en/), Kotlin overview
Kotlin is an object-oriented and functional programming language created by **JetBrains**.
It is the (other) official language for Android development.

## Key features
* Interoperability with JVM
* Cross-platform
* Statically typed with type inference
* Object-oriented
* Functional
* Target JVM or JS
* One of the fastest growing language
* Open-source
* Fully supported by IntelliJ with code conversion from/to Java
* Already a lot of dedicated tools, frameworks

## Code sample
```Kotlin
fun main() = println("Hello")
```

## Some nice stuff
* Null safe by default
* Extension function
* Complex switch cases
* `if`...`else` and `try`...`catch` (and a lot more) are instructions with a return value, making the java ternary operator obsolete.
* Ranges (`1..10` for instance)
* Data classes
* Object (singleton)
* Companion object
* Delegated properties
* Default value for method parameters
* Named arguments
* `let` keyword allowing object initialization and configuration in a single block
* Destructuring declaration

## Useful links
* [Language documentation](https://kotlinlang.org/docs/reference/)
* [Nice overview of the language with some editable code samples](https://try.kotlinlang.org)
* [Online editor for a simple Kotlin file](https://play.kotlinlang.org)
* [Training with a set of exercises to complete](https://play.kotlinlang.org/koans/overview)
* [The sources of Kotlin](https://github.com/JetBrains/kotlin)

## Exercises

Compiling and running the exercises can be achieved with gradle:
```bash
./gradlew run
```
Then a [Micronaut](https://micronaut.io/) server will start.

* Base address is http://localhost:8080
* Remote port is `8000`
* Health check is http://localhost:8080/health
* OpenAPI file is http://localhost:8080/openapi/kotlin-training-1.0.yml 

### REST Web server with Micronaut

Fill the `HelloController` class to make it answer the following JSON:
```json
{
  "content": "Hello world!"
}
```

### Create a new POST endpoint

Create a new `/companies` **POST** endpoint that will take a JSON like
```json
{
  "name": "Antaes"
}
```

and return the following response:
```json
{
  "self": "http://localhost:8080/companies/1",
  "name": "Antaes"
}
```

### Create a new GET endpoint

Create a new `/companies` **GET** endpoint that will return the location of recorded *companies*:
```json
[
  "http://localhost:8080/companies/1",
  "http://localhost:8080/companies/2"
]
```

### Create a new PUSH endpoint

Create a new `/companies/{id}` **PUSH** endpoint that will update the corresponding company data and returns it:
```json
{
  "name": "Antaes Consulting S.A.",
  "creationYear": 2007
}
```
Response:
```json
{
  "self": "http://localhost:8080/companies/1",
  "name": "Antaes Consulting S.A.",
  "creationYear": 2007
}
```