package com.projector.users.respository

import com.mongodb.client.model.Filters
import com.projector.common.mongo.CollectionFactory
import com.projector.common.mongo.EntityCollection
import com.projector.users.modal.Password
import com.projector.users.modal.User
import com.projector.users.respository.mapper.UserDocumentMapper
import org.bson.conversions.Bson
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(val collectionFactory:CollectionFactory):UserRepository{
    private val COLLECTION_NAME = "users"
    private val USERNAME = "username"
    private val PASSWORD = "password"
    private val entityCollection:EntityCollection<User> = collectionFactory.create(COLLECTION_NAME,UserDocumentMapper)

    override fun save(domain: User) {
        entityCollection.save(domain);
    }

    override fun findUser(username:String): User? {
        return entityCollection.findOne(Filters.eq(USERNAME,username))
    }
}