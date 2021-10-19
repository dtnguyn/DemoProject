package com.nguyen.demoproject.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nguyen.demoproject.db.entity.ItemCacheEntity

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertManyItems(items: List<ItemCacheEntity>)

    @Query("SELECT * FROM items")
    suspend fun getItems(): List<ItemCacheEntity>

}