package com.projector.projects

import com.projector.common.http.IterateOrThrow
import com.projector.common.http.transformOrThrow
import com.projector.projects.bean.ProjectBean
import com.projector.projects.bean.ProjectPostBean
import com.projector.projects.services.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import javax.ws.rs.*
import javax.ws.rs.core.MediaType


@Path("/projects")
class ProjectsResource {
    @Autowired
    lateinit var projectService: ProjectService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    fun getProjects(): List<ProjectBean> {
        return listOf()//projectService.getAllProjects().IterateOrThrow { ProjectBean.from(this) };

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    fun createProject(projectPostBean: ProjectPostBean): ProjectBean {
        return projectService.create(
                projectPostBean.toDomain()
        ).transformOrThrow { ProjectBean.from(this) }

    }

}