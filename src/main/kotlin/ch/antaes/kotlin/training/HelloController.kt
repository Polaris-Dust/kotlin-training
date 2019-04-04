package ch.antaes.kotlin.training

import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import javax.inject.Inject

@Controller("/hello")
class HelloController(@Inject val mapper: ObjectMapper) {
    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun index(): String {
        throw NotImplementedError("TODO")
    }
}