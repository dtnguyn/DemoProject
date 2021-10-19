package com.nguyen.demoproject.db.mapper

import com.nguyen.demoproject.db.entity.ItemCacheEntity
import com.nguyen.demoproject.model.Item

object ItemMapper {

    fun mapFromCache(cacheItem: ItemCacheEntity): Item {
        return Item(
            id = cacheItem.id,
            listId = cacheItem.listId,
            name = cacheItem.name
        )
    }

    fun mapToCache(item: Item): ItemCacheEntity {
        return ItemCacheEntity(
            id = item.id,
            listId = item.listId,
            name = item.name
        )
    }

    fun mapFromCacheList(cacheItems: List<ItemCacheEntity>): List<Item>{
        return cacheItems.map{
            mapFromCache(it)
        }
    }

    fun mapToCacheList(items: List<Item>): List<ItemCacheEntity>{
        return items.map {
            mapToCache(it)
        }
    }

}