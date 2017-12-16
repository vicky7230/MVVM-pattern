package com.paprika.thali

import android.app.Activity
import android.app.Application
import com.amitshekhar.DebugDB
import com.paprika.thali.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by vicky on 7/12/17.
 */
class ThaliApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this)

        Timber.plant(Timber.DebugTree())

        DebugDB.getAddressLog()
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }

}