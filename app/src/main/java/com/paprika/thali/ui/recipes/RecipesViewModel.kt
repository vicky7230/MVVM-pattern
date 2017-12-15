package com.paprika.thali.ui.recipes

import android.arch.lifecycle.ViewModel
import com.paprika.thali.data.DataManager
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by vicky on 15/12/17.
 */
class RecipesViewModel
constructor(private val dataManager: DataManager, private val compositeDisposable: CompositeDisposable) : ViewModel() {

    fun getRecipesFromFirebase() {
        dataManager.getRecipes()
    }
}