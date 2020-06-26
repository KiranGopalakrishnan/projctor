package com.projector.projects.services

import com.projector.common.http.NotFound
import com.projector.common.http.Response
import com.projector.common.http.Success
import com.projector.projects.modals.Project
import com.projector.projects.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProjectService {
    @Autowired
    lateinit var projectRepository: ProjectRepository
    fun getAllProjects(): Response<List<Project>>{
        val projects = projectRepository.getAllProjects()
        return if(projects != null){
            Success(projects)
        }else{
            NotFound{ "No projects found" }
        }
    }

    fun create(project: Project):Response<Project>{
        projectRepository.save(project)
        return Success(project)
    }

}