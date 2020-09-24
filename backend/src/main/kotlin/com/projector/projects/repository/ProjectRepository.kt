package com.projector.projects.repository

import com.mongodb.client.model.Filters
import com.projector.common.mongo.CollectionFactory
import com.projector.common.mongo.EntityCollection
import com.projector.projects.modals.Project
import com.projector.projects.modals.ProjectId
import com.projector.projects.repository.mapper.ProjectDocumentMapper
import com.projector.users.modal.User
import org.springframework.stereotype.Repository

@Repository
class ProjectRepository(val collectionFactory: CollectionFactory) {

    private val COLLECTION_NAME = "projects"

    private val entityCollection: EntityCollection<Project> = collectionFactory.create(COLLECTION_NAME, ProjectDocumentMapper)

    fun save(project: Project) {
         entityCollection.save(project)
    }

    fun getAllProjects(): List<Project>? {
        return entityCollection.findAll()
    }

    fun getProject(id: ProjectId): Project? {
        return entityCollection.findOne(Filters.eq(ProjectDocument.ID.toKey(),id.id))
    }
}