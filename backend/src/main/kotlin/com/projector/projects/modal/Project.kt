package com.projector.projects.modal

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("projects")
class Projects {
    @Id
    var id: String? = null
    var name: String? = null

    constructor() {}
    constructor(name: String?) {
        this.name = name
    }

    override fun toString(): String {
        return String.format("Customer[id=%s, name='%s]", id, name)
    }
}