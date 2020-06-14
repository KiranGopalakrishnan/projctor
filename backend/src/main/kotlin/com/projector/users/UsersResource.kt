package com.projector.users

import com.projector.common.http.IterateOrThrow
import com.projector.common.http.transformOrThrow
import com.projector.users.bean.UserBean
import com.projector.users.bean.UserPostBean
import com.projector.users.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/users")
class UsersResource {
    @Autowired
    lateinit var userService: UserService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    fun getUsers(): List<UserBean> {
         return userService.getAllUsers().IterateOrThrow { UserBean.from(this) };

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    fun addUser(userPostBean: UserPostBean): UserBean {
        return userService.addUser(
                userPostBean.toDomain()
        ).transformOrThrow { UserBean.from(this) }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/authenticate")
    fun authenticateUser(user: UserPostBean): UserBean {
        return userService.authenticateUser(
                username =  user.username,
                password = user.password
        ).transformOrThrow { UserBean.from(this) }

    }

}