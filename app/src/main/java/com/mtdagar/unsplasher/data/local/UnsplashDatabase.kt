package com.mtdagar.unsplasher.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mtdagar.unsplasher.data.local.dao.UnsplashImageDao
import com.mtdagar.unsplasher.data.local.dao.UnsplashRemoteKeysDao
import com.mtdagar.unsplasher.model.UnsplashImage
import com.mtdagar.unsplasher.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1, exportSchema = false)
abstract class UnsplashDatabase: RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}