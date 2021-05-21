package br.com.ecommerce.pub.service

import br.com.ecommerce.sub.model.User
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface UserClient {

    @Subject("my-user")
    fun send(user: User)
}
