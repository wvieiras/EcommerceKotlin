package user

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
class User(
    val id: UUID?,
    val login: String?,
    val password: String?,
)
