package com.projector.common.http

sealed class Response<out T: Any>;

data class Success<out T : Any>(val value: T) : Response<T>()
object NoContent : Response<Nothing>()

sealed class Errors(val getMessage: () -> String) : Response<Nothing>()
data class NotFound(val e: () -> String = { "Entity not found" }) : Errors(e)
data class UnprocessableEntity(val e: () -> String = { "Entity not found" }) : Errors(e)
data class InvalidRequest(val e: () -> String = { "Invalid request" }) : Errors(e)
data class NoPermission(val e: () -> String) : Errors(e)