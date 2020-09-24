package com.projector.projects.repository

import com.projector.common.mongo.DocumentKeys

enum class ProjectDocument:DocumentKeys {
 ID {
     override fun toKey(): String  =  this.toString().toLowerCase()
 },NAME {
        override fun toKey(): String  =  this.toString().toLowerCase()
    }
}