package com.paprika.thali.data.db.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by vicky on 7/12/17.
 */
@Entity(tableName = "recipes")
data class Recipe(
        @SerializedName("id")
        @Expose
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: Int,

        @SerializedName("recipe_name")
        @Expose
        @ColumnInfo(name = "recipe_name")
        val recipeName: String,

        @SerializedName("image_url")
        @Expose
        @ColumnInfo(name = "image_url")
        val imageUrl: String,

        @SerializedName("directions")
        @Expose
        @ColumnInfo(name = "directions")
        val directions: String,

        @SerializedName("is_veg")
        @Expose
        @ColumnInfo(name = "is_veg")
        val isVeg: Boolean,

        @SerializedName("page_link")
        @Expose
        @ColumnInfo(name = "page_link")
        val pageLink: String
)