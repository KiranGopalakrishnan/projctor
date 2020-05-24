package com.projector.projects

import com.projector.projects.repo.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.ws.rs.GET
import javax.ws.rs.Path


@Component
@Path("/test")
class Projects {

    @Autowired
    lateinit var repository: ProjectRepository;

    @GET
    @Path("/hello")
    fun test(): String{
       return repository.findAll().toString()
    }


}