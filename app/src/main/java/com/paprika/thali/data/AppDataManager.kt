package com.paprika.thali.data

import com.paprika.thali.data.db.DbHelper
import com.paprika.thali.data.network.ApiHelper
import javax.inject.Inject


/**
 * Created by vicky on 7/12/17.
 */
class AppDataManager @Inject constructor(val apiHelper: ApiHelper, val dbHelper: DbHelper) : DataManager {

    override fun getRecipes() {
        apiHelper.getRecipes()
    }

}