package com.projector.users.respository.mapper

import com.projector.common.mongo.DocumentMapper
import com.projector.users.modal.Password
import com.projector.users.modal.User
import com.projector.users.modal.UserId
import org.bson.Document

object UserDocumentMapper:DocumentMapper<User> {

    override fun toDocument(domainObject: User): Document {
        val document:Document =  Document()
        document.append("id", domainObject.id?.value)
        document.append("username",domainObject.username)
        document.append("password",domainObject.password.toEncrypted())
        return document
    }

    override fun fromDocument(document: Document): User {
        val username = document.getString("username")
        val password = document.getString("password")
        val id = document.getString("id")
        return User(id= UserId(id),username = username,password = Password(password))
    }

}