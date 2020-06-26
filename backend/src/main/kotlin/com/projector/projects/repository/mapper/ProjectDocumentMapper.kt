package com.projector.projects.repository.mapper

import com.projector.common.mongo.DocumentMapper
import com.projector.projects.modals.Project
import com.projector.projects.modals.ProjectId
import com.projector.projects.repository.ProjectDocument
import org.bson.Document

object ProjectDocumentMapper: DocumentMapper<Project> {
    override fun toDocument(domainObject: Project): Document {
        val document = Document()
        document.append(ProjectDocument.ID.toKey(), domainObject.id?.id)
        document.append(ProjectDocument.NAME.toKey(),domainObject.name)
        return document
    }

    override fun fromDocument(document: Document): Project {
        val id = document.getString(ProjectDocument.ID.toKey())
        val name = document.getString(ProjectDocument.NAME.toKey())
        return Project(id = ProjectId(id), name = name )
    }
}