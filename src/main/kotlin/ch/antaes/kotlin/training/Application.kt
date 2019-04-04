package ch.antaes.kotlin.training

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info = Info(
        title = "kotlin-training",
        version = "1.0"
    )
)
object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
            .packages("ch.antaes.kotlin.training")
            .mainClass(Application.javaClass)
            .start()
    }
}