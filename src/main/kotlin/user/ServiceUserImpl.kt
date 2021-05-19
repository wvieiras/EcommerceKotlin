package user

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import javax.inject.Singleton

@Singleton
class ServiceUserImpl(private val session: CqlSession): ServiceUser {
    override fun createUser(user: User): User {
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
}
