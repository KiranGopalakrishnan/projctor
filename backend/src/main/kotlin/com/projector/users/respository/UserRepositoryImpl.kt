package com.projector.users.respository

import com.mongodb.client.model.Filters
import com.projector.common.mongo.CollectionFactory
import com.projector.common.mongo.EntityCollection
import com.projector.users.modal.User
import com.projector.users.respository.mapper.UserDocumentMapper
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(val collectionFactory:CollectionFactory):UserRepository{
    private val COLLECTION_NAME = "users"
    private val entityCollection:EntityCollection<User> = collectionFactory.create(COLLECTION_NAME,UserDocumentMapper)

    override fun save(domain: User) {
        entityCollection.save(domain);
    }

    override fun findUser(email:String): User? {
        return entityCollection.findOne(Filters.eq(UserDocument.EMAIL.toKey(),email))
    }

    override fun findAllUsers(): List<User>? {
        return entityCollection.findAll()
    }

}