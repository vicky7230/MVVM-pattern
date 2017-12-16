package com.paprika.thali.ui.recipes

import android.arch.lifecycle.ViewModel
import com.paprika.thali.data.DataManager
import com.paprika.thali.data.db.room.Recipe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.*
import javax.inject.Inject

/**
 * Created by vicky on 15/12/17.
 */
class RecipesViewModel
constructor(private val dataManager: DataManager, private val compositeDisposable: CompositeDisposable) : ViewModel() {

    fun getRecipesFromFirebase() {
        val list: MutableList<Recipe> = dataManager.getRecipes()
        dataManager.saveRecipes(list)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it: Long? ->
                    Timber.d("Inserted $it items.")
                }, { it: Throwable? ->
                    Timber.e("Error : $it")
                })
    }
}