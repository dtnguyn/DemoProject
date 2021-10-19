package com.nguyen.demoproject.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nguyen.demoproject.db.dao.ItemDao

@Database(
    entities = [],
    version = 0,
    exportSchema = false
)
abstract class DemoDatabase: RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object{
        val DATABASE_NAME: String = "demo_db"
    }
}