package com.nguyen.demoproject.api.service

import com.nguyen.demoproject.model.Item
import retrofit2.http.GET

interface HiringService {

    @GET("/hiring.json")
    suspend fun getItems(): List<Item>

}