package com.paprika.thali.data.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import timber.log.Timber
import javax.inject.Inject
import com.google.gson.reflect.TypeToken
import com.paprika.thali.data.db.room.Recipe


/**
 * Created by vicky on 7/12/17.
 */
class AppApiHelper @Inject
constructor(private val firebaseFirestore: FirebaseFirestore, private val gson: Gson) : ApiHelper {

    override fun getRecipes(): MutableList<Recipe> {
        val list: MutableList<Recipe> = ArrayList()
        firebaseFirestore.collection("recipes_english")
                .get()
                .addOnCompleteListener({ task ->
                    if (task.isSuccessful) {
                        for (document in task.result) {
                            val type = object : TypeToken<Map<String, Any>>() {}.type
                            list.add(gson.fromJson(gson.toJson(document.data, type), Recipe::class.java))
                            Timber.d(document.id + " => " + gson.toJson(document.data, type))
                        }
                    } else {
                        Timber.d("Error getting documents: " + task.exception)
                    }
                })

        return list
    }
}