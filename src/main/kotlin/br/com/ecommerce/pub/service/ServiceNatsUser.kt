package br.com.ecommerce.pub.service

import br.com.ecommerce.sub.model.User

interface ServiceNatsUser {
    fun send(user: User): User
}