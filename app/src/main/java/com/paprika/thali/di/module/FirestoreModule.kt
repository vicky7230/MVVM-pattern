package com.paprika.thali.di.module

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by vicky on 7/12/17.
 */
@Module
class FirestoreModule {

    @Provides
    @Singleton
    fun provideFirebaseFirestoreDb(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }
}