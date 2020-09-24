package com.projector.projects.bean

import com.projector.projects.modals.Project
import com.projector.users.modal.Password
import com.projector.users.modal.User

data class ProjectPostBean(
        val name: String
) {


    fun toDomain(): Project {
        return Project(
                name = name
        )
    }
}