package com.nguyen.demoproject.api.service

import com.nguyen.demoproject.model.Item
import retrofit2.http.GET

interface HiringService {

    @GET("/DemoProject")
    suspend fun getItems(): List<Item>

}