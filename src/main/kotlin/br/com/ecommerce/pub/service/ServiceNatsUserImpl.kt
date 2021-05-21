package br.com.ecommerce.pub.service

import br.com.ecommerce.sub.model.User
import javax.inject.Singleton

@Singleton
class ServiceNatsUserImpl(private val userClient: UserClient): ServiceNatsUser {
    override fun send(user: User): User {
        userClient.send(user)
        return user
    }
}