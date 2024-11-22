package org.example.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

fun getUserDatabase() : UserDatabase {
    val dbFile = NSHomeDirectory() + "user.db"
    return Room.databaseBuilder<UserDatabase>(
        name = dbFile,
        factory = { UserDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()

}