package com.paprika.thali.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.paprika.thali.ThaliApplication
import com.paprika.thali.data.AppDataManager
import com.paprika.thali.data.DataManager
import com.paprika.thali.data.db.AppDbHelper
import com.paprika.thali.data.db.DbHelper
import com.paprika.thali.data.db.room.AppDatabase
import com.paprika.thali.data.network.ApiHelper
import com.paprika.thali.data.network.AppApiHelper
import com.paprika.thali.di.ApplicationContext
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


/**
 * Created by vicky on 7/12/17.
 */
@Module
class ApplicationModule {

    @Provides
    @ApplicationContext
    fun provideContext(thaliApplication: ThaliApplication): Context {
        return thaliApplication.applicationContext
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "recipes_db").build()
    }

    @Provides
    @Singleton
    fun provideFirebaseFirestoreDb(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

}