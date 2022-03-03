package com.mtdagar.unsplasher.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mtdagar.unsplasher.data.local.UnsplashDatabase
import com.mtdagar.unsplasher.data.paging.UnsplashRemoteMediator
import com.mtdagar.unsplasher.data.remote.UnsplashApi
import com.mtdagar.unsplasher.model.UnsplashImage
import com.mtdagar.unsplasher.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
) {

    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { unsplashDatabase.unsplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

//    fun searchImages(query: String): Flow<PagingData<UnsplashImage>> {
//        return Pager(
//            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
//            pagingSourceFactory = {
//                SearchPagingSource(unsplashApi = unsplashApi, query = query)
//            }
//        ).flow
//    }
}