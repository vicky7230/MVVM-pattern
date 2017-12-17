package com.paprika.thali.data.network

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.gson.Gson
import javax.inject.Inject


/**
 * Created by vicky on 7/12/17.
 */
class AppApiHelper @Inject
constructor(private val firebaseFirestore: FirebaseFirestore, private val gson: Gson) : ApiHelper {

    override fun getRecipes(): Task<QuerySnapshot> {
        return firebaseFirestore.collection("recipes_english").get()
    }
}