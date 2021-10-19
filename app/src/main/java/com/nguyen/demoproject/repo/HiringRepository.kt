package com.nguyen.demoproject.repo

import com.nguyen.demoproject.api.service.HiringService
import com.nguyen.demoproject.db.DemoDatabase
import com.nguyen.demoproject.model.Item
import com.nguyen.demoproject.utils.UIState
import kotlinx.coroutines.flow.Flow

class HiringRepository(
    val api: HiringService,
    val db: DemoDatabase
) {

    suspend fun getItem(): Flow<UIState<Item>>{
        return getNetworkBoundResource(
            query = {
                val cacheItems = db.itemDao().getItems()
            },
            fetch = {

            },
            saveFetchResult = {

            }
        )
    }

}