package br.com.ecommerce.controller

import br.com.ecommerce.pub.controller.UserController
import br.com.ecommerce.pub.service.ServiceNatsUserImpl
import br.com.ecommerce.sub.model.User
import br.com.ecommerce.sub.service.ServiceUser
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*


@MicronautTest
class UserControllerTest: AnnotationSpec() {

    private val serviceNatsUserImpl = mockk<ServiceNatsUserImpl>()
    private val serviceUser = mockk<ServiceUser>()

    private val userController = UserController(serviceUser, serviceNatsUserImpl)

    private lateinit var user: User

    @BeforeEach
    fun setUp(){
        user = User(UUID.randomUUID(), "vieira@live.com.br", "123456")
    }



    @Test
    fun `creating a new user success`(){
        every { serviceNatsUserImpl.send(any()) } answers { user }
        val result = serviceNatsUserImpl.send(user)
        result shouldBe user
    }

}