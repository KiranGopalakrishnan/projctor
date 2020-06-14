package com.projector.users.respository.mapper

import com.projector.common.mongo.DocumentMapper
import com.projector.users.modal.Password
import com.projector.users.modal.User
import com.projector.users.modal.UserId
import org.bson.Document

object UserDocumentMapper:DocumentMapper<User> {

    override fun toDocument(domainObject: User): Document {
        val document =  Document()
        document.append("id", domainObject.id?.value)
        document.append("username",domainObject.username)
        document.append("password",domainObject.password.toEncrypted())
        document.append("firstname",domainObject.firstname)
        document.append("lastname",domainObject.lastname)
        return document
    }

    override fun fromDocument(document: Document): User {

        val id = document.getString("id")
        val firstname = document.getString("firstname")
        val lastname = document.getString("lastname")
        val username = document.getString("username")
        val password = document.getString("password")

        return User(
                id= UserId(id),
                username = username,
                password = Password(password),
                firstname = firstname,
                lastname = lastname
        )
    }

}