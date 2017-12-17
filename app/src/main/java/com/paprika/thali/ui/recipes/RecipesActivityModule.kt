package com.paprika.thali.ui.recipes

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.paprika.thali.data.DataManager
import com.paprika.thali.di.ApplicationContext
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by vicky on 15/12/17.
 */
@Module
class RecipesActivityModule {

    @Provides
    fun provideRecipesViewModel(dataManager: DataManager, compositeDisposable: CompositeDisposable, gson: Gson): RecipesViewModel {
        return RecipesViewModel(dataManager, compositeDisposable, gson)
    }

    @Provides
    fun provideRecipesAdapter(): RecipesAdapter {
        return RecipesAdapter(ArrayList())
    }

    @Provides
    fun provideLinearLayoutManager(@ApplicationContext context: Context): LinearLayoutManager {
        return LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}