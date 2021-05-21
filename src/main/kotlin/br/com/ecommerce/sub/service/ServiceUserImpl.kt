package br.com.ecommerce.sub.service

import br.com.ecommerce.sub.model.User
import br.com.ecommerce.sub.repository.UserRepository
import com.datastax.oss.driver.api.core.CqlSession
import javax.inject.Singleton

@Singleton
class ServiceUserImpl(private val userRepository: UserRepository): ServiceUser {
    override fun createUser(user: User): User {
        return userRepository.createUser(user)
    }

    override fun getAll(): List<User>{
        return userRepository.getAll()
    }

}
