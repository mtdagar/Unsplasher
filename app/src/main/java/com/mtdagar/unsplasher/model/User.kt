package com.mtdagar.unsplasher.model

import androidx.room.Embedded
import kotlinx.serialization.SerialName

data class User(
    @SerialName("links")
    @Embedded
    val userLinks: UserLinks,
    val username: String
)
