package org.example.firebaseAuthentication

// iosMain/FirebaseAuthManager.kt
import kotlinx.coroutines.suspendCancellableCoroutine
import platform.FirebaseAuth.FIRAuth
import platform.FirebaseAuth.FIRAuth.auth
import platform.Foundation.NSError
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class FirebaseAuthManager : AuthManager {
    override suspend fun signIn(email: String, password: String): Result<Unit> {
        return suspendCancellableCoroutine { continuation ->
            auth()?.signInWithEmail(email, password) { _, error ->
                if (error != null) {
                    continuation.resume(Result.failure(Exception(error.localizedDescription)))
                } else {
                    continuation.resume(Result.success(Unit))
                }
            }
        }
    }

    override suspend fun signUp(email: String, password: String): Result<Unit> {
        return suspendCancellableCoroutine { continuation ->
            auth()?.createUserWithEmail(email, password) { _, error ->
                if (error != null) {
                    continuation.resume(Result.failure(Exception(error.localizedDescription)))
                } else {
                    continuation.resume(Result.success(Unit))
                }
            }
        }
    }
}
