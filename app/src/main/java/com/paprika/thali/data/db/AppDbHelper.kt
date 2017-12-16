package com.paprika.thali.data.db

import com.paprika.thali.data.db.room.AppDatabase
import com.paprika.thali.data.db.room.Recipe
import io.reactivex.Flowable
import javax.inject.Inject


/**
 * Created by vicky on 7/12/17.
 */
class AppDbHelper @Inject
constructor(val appDatabase: AppDatabase) : DbHelper {
    override fun saveRecipes(list: MutableList<Recipe>): Flowable<Long> {
        return appDatabase.recipeDao().insertAll(list)
    }
}