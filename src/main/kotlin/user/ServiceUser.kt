package user

import javax.inject.Singleton

@Singleton
interface ServiceUser {
    fun createUser(user: User): User
    fun getAll(): List<User>
}
