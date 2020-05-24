package com.projector.projects.repo

import com.projector.projects.modal.Projects
import org.springframework.data.repository.CrudRepository


interface ProjectRepository : CrudRepository<Projects?, String?> {}