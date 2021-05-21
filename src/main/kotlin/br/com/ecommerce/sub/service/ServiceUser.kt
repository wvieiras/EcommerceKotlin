package br.com.ecommerce.sub.service

import br.com.ecommerce.sub.model.User
import javax.inject.Singleton

@Singleton
interface ServiceUser {
    fun createUser(user: User): User
    fun getAll(): List<User>
}
