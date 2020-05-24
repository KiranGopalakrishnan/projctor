package com.projector.projects.services

import com.projector.projects.repo.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired

class ProjectService {
    @Autowired
    lateinit var repository: ProjectRepository;
}