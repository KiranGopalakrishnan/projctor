package com.projector.users.respository

import com.projector.common.mongo.DocumentKeys

enum class UserDocument: DocumentKeys {
    ID{
        override fun toKey(): String{
            return  this.name.toLowerCase();
        }
    },
    EMAIL{
        override fun toKey(): String{
            return  this.name.toLowerCase();
        }
    },PASSWORD{
        override fun toKey(): String{
            return  this.name.toLowerCase();
        }
    },FIRSTNAME{
        override fun toKey(): String{
            return  this.name.toLowerCase();
        }
    },LASTNAME{
        override fun toKey(): String{
            return  this.name.toLowerCase();
        }
    };
}