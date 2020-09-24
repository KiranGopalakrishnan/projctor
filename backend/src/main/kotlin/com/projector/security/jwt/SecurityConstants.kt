package com.projector.security.jwt

object SecurityConstants {
    const val SECRET = "projector-jwt-key"
    const val EXPIRATION_TIME: Long = 864000000 // 10 days
    const val TOKEN_PREFIX = "Bearer "
    const val HEADER_STRING = "Authorization"
    const val SIGN_UP_URL = "/users"
}