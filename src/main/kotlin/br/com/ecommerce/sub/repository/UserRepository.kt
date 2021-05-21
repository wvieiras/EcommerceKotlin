package br.com.ecommerce.sub.repository

import br.com.ecommerce.sub.model.User
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import javax.inject.Singleton

@Singleton
class UserRepository( private val session: CqlSession) {
    fun createUser(user: User): User {
        val userCreated = User(user.id, user.login, user.password)
        session.execute(
            SimpleStatement.newInstance(
                "INSERT INTO ecommerce.User(id,login,password) VALUES (?,?,?)",
                userCreated.id,
                userCreated.login,
                userCreated.password,
            )
        )
        return userCreated
    }

    fun getAll(): List<User> {
        var results = session.execute("SELECT * from ecommerce.User")
        val res = results.map {
            User(
                it.getUuid("id"), it.getString("login"), it.getString("password")
            )
        }

        return res.toList()
    }
}