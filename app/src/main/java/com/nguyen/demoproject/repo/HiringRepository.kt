package com.nguyen.demoproject.repo

import com.nguyen.demoproject.api.service.HiringService
import com.nguyen.demoproject.db.DemoDatabase
import com.nguyen.demoproject.db.mapper.ItemMapper
import com.nguyen.demoproject.model.Item
import com.nguyen.demoproject.utils.UIState
import kotlinx.coroutines.flow.Flow

class HiringRepository(
    val api: HiringService,
    val db: DemoDatabase
) {

    suspend fun getItems(): Flow<UIState<List<Item>>>{
        return getNetworkBoundResource(
            query = {
                val cacheItems = db.itemDao().getItems()
                ItemMapper.mapFromCacheList(cacheItems)
            },
            fetch = {
                val items = api.getItems()
                items
            },
            saveFetchResult = {cacheItems ->
                cacheItems?.let{
                    db.itemDao().insertManyItems(ItemMapper.mapToCacheList(it))
                }
            }
        )
    }

}