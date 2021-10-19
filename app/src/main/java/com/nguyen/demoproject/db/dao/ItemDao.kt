package com.nguyen.demoproject.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.nguyen.demoproject.db.entity.ItemCacheEntity

@Dao
interface ItemDao {

    @Query("SELECT * FROM items")
    suspend fun getItems(): List<ItemCacheEntity>

}