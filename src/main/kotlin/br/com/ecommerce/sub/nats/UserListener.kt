package br.com.ecommerce.sub.nats

import br.com.ecommerce.sub.service.ServiceUserImpl
import br.com.ecommerce.sub.model.User
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject

@NatsListener
class UserListener (private val serviceUserImpl: ServiceUserImpl) {

    @Subject("my-user")
    fun receive(user: User){
        serviceUserImpl.createUser(user)
    }
}