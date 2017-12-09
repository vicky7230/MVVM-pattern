package com.paprika.thali.data.db.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by vicky on 7/12/17.
 */
@Entity(tableName = "recipes")
data class Recipe(
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: Int,

        @ColumnInfo(name = "recipe_name")
        val recipeName: String,

        @ColumnInfo(name = "image_url")
        val imageUrl: String,

        @ColumnInfo(name = "directions")
        val directions: String,

        @ColumnInfo(name = "is_veg")
        val isVeg: Boolean,

        @ColumnInfo(name = "page_link")
        val pageLink: String
)