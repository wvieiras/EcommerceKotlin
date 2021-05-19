package user

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller
class UserController (private val service: ServiceUser) {

    @Post("/usuario")
    @Produces(APPLICATION_JSON)
    fun post(@Body @Valid request: NewUserRequest): HttpResponse<Any> {

        val user = request.toModel()
        //service.createUser(user)

        //return HttpResponse.ok(user)
        return HttpResponse.created(HttpStatus.CREATED).body(this.service.createUser(user))
    }

}