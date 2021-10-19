package com.nguyen.demoproject.api.service

import retrofit2.http.GET

interface HiringService {

    @GET("/DemoProject")
    suspend fun getItems()

}