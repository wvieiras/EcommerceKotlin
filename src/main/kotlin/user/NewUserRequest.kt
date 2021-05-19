package user

import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class NewUserRequest (

    @field:Email
    @field:NotBlank
    val login: String,

    @field:NotBlank
    @field:Size(min=6)
    val password: String
) {
    fun toModel(): User {
        return User(UUID.randomUUID(),login, password)
    }
}
