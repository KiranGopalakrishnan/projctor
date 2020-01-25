package com.projector.projects

import org.springframework.stereotype.Component
import javax.ws.rs.GET
import javax.ws.rs.Path

@Component
@Path("/test")
class Projects {
    @GET
    @Path("/hello")
    fun test(): String{
        return "hello";
    }


}