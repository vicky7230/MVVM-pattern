package com.paprika.thali.data.network

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import com.paprika.thali.data.db.room.Recipe
import io.reactivex.Observable

/**
 * Created by vicky on 7/12/17.
 */
interface ApiHelper {

    fun getRecipes(): Task<QuerySnapshot>
}