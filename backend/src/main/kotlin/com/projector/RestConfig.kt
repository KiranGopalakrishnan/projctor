package com.projector

import com.projector.users.UsersResource
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component

@Component
class RestConfig: ResourceConfig(){

    init {
        registerEndPoints()
    }

    fun registerEndPoints() {
        register(UsersResource())
    }

}