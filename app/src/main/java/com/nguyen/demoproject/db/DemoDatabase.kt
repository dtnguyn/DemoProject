package com.nguyen.demoproject.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nguyen.demoproject.db.dao.ItemDao
import com.nguyen.demoproject.db.entity.ItemCacheEntity

@Database(
    entities = [ItemCacheEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DemoDatabase: RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object{
        val DATABASE_NAME: String = "demo_db"
    }
}