package com.paprika.thali.data.db.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by vicky on 7/12/17.
 */
@Database(entities = [Recipe::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
}