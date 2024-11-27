package org.example.firebaseAuthentication

actual fun getAuthManager(): AuthManager = FirebaseAuthManager()
