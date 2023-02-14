package com.example.usecases

abstract class Failure : Throwable()

sealed class GlobalFailure : Failure() {
    object NetworkConnection : GlobalFailure()
    object TokenError : GlobalFailure()
    class ServiceFailure(val code : Int, override val message : String) : GlobalFailure()
    class ServerFailure(override val message : String, val url: String) : GlobalFailure()
    data class AuthorizationError(override val message: String) : GlobalFailure()
    data class GlobalError(val throwable: Throwable) : GlobalFailure()
}
