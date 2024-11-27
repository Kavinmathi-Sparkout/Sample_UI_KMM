package org.example.firebaseAuthentication

// commonMain/AuthManager.kt
interface AuthManager {
    suspend fun signIn(email: String, password: String): Result<Unit>
    suspend fun signUp(email: String, password: String): Result<Unit>
}
