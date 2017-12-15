package com.paprika.thali.di.module

import com.paprika.thali.ui.recipes.RecipesActivity
import com.paprika.thali.ui.recipes.RecipesActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by vicky on 15/12/17.
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [RecipesActivityModule::class])
    abstract fun bindRecipesActivity(): RecipesActivity
}