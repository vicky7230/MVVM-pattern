package com.paprika.thali.data.db.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by vicky on 7/12/17.
 */
@Dao
interface RecipeDao {

    @Insert
    fun insertAll(recipes: MutableList<Recipe>): List<Long>

    @Query("SELECT * FROM recipes")
    fun getAll(): List<Recipe>
}