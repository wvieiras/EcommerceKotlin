package br.com.ecommerce.pub.controller

import br.com.ecommerce.sub.service.ServiceUser
import br.com.ecommerce.sub.model.User
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import br.com.ecommerce.pub.model.UserRequest
import br.com.ecommerce.pub.service.ServiceNatsUserImpl
import javax.validation.Valid

@Validated
@Controller
class UserController (private val service: ServiceUser, private val serviceNats: ServiceNatsUserImpl) {

    @Post("/usuario")
    @Produces(APPLICATION_JSON)
    fun post(@Body @Valid request: UserRequest): HttpResponse<Any> {

        val user = request.toModel()


        //this.service.createUser(user)
        return HttpResponse.created(HttpStatus.CREATED).body(serviceNats.send(user))
    }

    @Get
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    fun getAll() :HttpResponse<List<User>> {
        val listTravel = this.service.getAll()
        return HttpResponse.ok(listTravel).body(this.service.getAll())
    }

}