package com.paprika.thali.data.network

import com.google.firebase.firestore.FirebaseFirestore
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by vicky on 7/12/17.
 */
class AppApiHelper @Inject
constructor(private val firebaseFirestore: FirebaseFirestore) : ApiHelper {

    override fun getRecipes() {

        firebaseFirestore.collection("recipes_english")
                .get()
                .addOnCompleteListener({ task ->
                    if (task.isSuccessful) {
                        for (document in task.result) {
                            Timber.d(document.id + " => " + document.data)
                        }
                    } else {
                        Timber.d("Error getting documents: " + task.exception)
                    }
                })
    }
}