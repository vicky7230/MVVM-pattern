package com.paprika.thali.ui.recipes

import com.paprika.thali.data.DataManager
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by vicky on 15/12/17.
 */
@Module
class RecipesActivityModule {

    @Provides
    fun provideRecipesViewModel(dataManager: DataManager, compositeDisposable: CompositeDisposable): RecipesViewModel {
        return RecipesViewModel(dataManager, compositeDisposable)
    }
}