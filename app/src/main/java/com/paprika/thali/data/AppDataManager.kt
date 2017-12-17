package com.paprika.thali.data

import android.arch.lifecycle.MutableLiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import com.paprika.thali.data.db.DbHelper
import com.paprika.thali.data.db.room.Recipe
import com.paprika.thali.data.network.ApiHelper
import javax.inject.Inject


/**
 * Created by vicky on 7/12/17.
 */
class AppDataManager @Inject constructor(val apiHelper: ApiHelper, val dbHelper: DbHelper) : DataManager {

    override fun getRecipes(): Task<QuerySnapshot> {
        return apiHelper.getRecipes()
    }

    override fun saveRecipes(list: MutableList<Recipe>): List<Long> {
        return dbHelper.saveRecipes(list)
    }

    override fun getAll(): MutableLiveData<MutableList<Recipe>> {
        return dbHelper.getAll()
    }
}