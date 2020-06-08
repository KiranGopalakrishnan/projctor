package com.projector.users

import com.projector.users.bean.UserBean
import com.projector.users.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.net.http.HttpResponse
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Component
@Path("/users")
class UsersResource {
    @Autowired
    lateinit var userService: UserService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    fun getUsers(): List<UserBean> {
         return userService.getAllUsers().map { UserBean.from(it) };
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/authenticate")
    fun authenticateUser(user:UserBean): UserBean? {
        return userService.authenticateUser(username =  user.username, password = user.password)?.let { UserBean.from(it) };

    }

}