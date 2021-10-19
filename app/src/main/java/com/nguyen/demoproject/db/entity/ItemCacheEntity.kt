package com.nguyen.demoproject.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
class ItemCacheEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "list_id")
    val listId: Int,

    @ColumnInfo(name = "name")
    val name: String?
)