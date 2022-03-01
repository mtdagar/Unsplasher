package com.mtdagar.unsplasher.data.remote

import retrofit2.http.Query

interface UnsplashApi {

    suspend fun getAllImages(
        @Query("page")page: Int,
        @Query("per_page")per_page: Int
    )

}