package com.paprika.thali.ui.recipes

import android.arch.lifecycle.ViewModel
import com.paprika.thali.data.DataManager
import com.paprika.thali.data.db.room.Recipe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by vicky on 15/12/17.
 */
class RecipesViewModel
constructor(private val dataManager: DataManager, private val compositeDisposable: CompositeDisposable) : ViewModel() {

    fun getRecipesFromFirebase() {
        val list: MutableList<Recipe> = dataManager.getRecipes()
        Observable.just(dataManager.saveRecipes(list))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it: List<Long>? -> Timber.d("Inserted ${it?.size} records") },
                        { it: Throwable? -> Timber.e("Error ${it?.message}") })
    }
}