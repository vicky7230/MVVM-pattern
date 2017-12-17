package com.paprika.thali.data.db

import android.arch.lifecycle.LiveData
import com.paprika.thali.data.db.room.AppDatabase
import com.paprika.thali.data.db.room.Recipe
import javax.inject.Inject


/**
 * Created by vicky on 7/12/17.
 */
class AppDbHelper @Inject
constructor(val appDatabase: AppDatabase) : DbHelper {
    override fun getAll(): LiveData<MutableList<Recipe>>? {
        return appDatabase.recipeDao().getAll()
    }

    override fun saveRecipes(list: MutableList<Recipe>): List<Long> {
        return appDatabase.recipeDao().insertAll(list)
    }
}