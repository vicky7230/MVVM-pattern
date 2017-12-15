package com.paprika.thali.di.component

import com.paprika.thali.ThaliApplication
import com.paprika.thali.di.module.ApplicationModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
import dagger.BindsInstance
import com.paprika.thali.di.module.ActivityBuilder


/**
 * Created by vicky on 9/12/17.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    ActivityBuilder::class
])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(thaliApplication: ThaliApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(thaliApplication: ThaliApplication)
}