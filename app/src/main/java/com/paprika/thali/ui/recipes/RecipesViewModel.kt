package com.paprika.thali.ui.recipes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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
constructor(private val dataManager: DataManager, private val compositeDisposable: CompositeDisposable, private val gson: Gson) : ViewModel() {

    var recipes: LiveData<MutableList<Recipe>>? = null

    fun getRecipesFromFirebase(): LiveData<MutableList<Recipe>>? {

        if (recipes == null) {
            recipes = dataManager.getAll()

            dataManager.getRecipes().addOnCompleteListener({ task ->
                if (task.isSuccessful) {
                    val list: MutableList<Recipe> = ArrayList()
                    for (document in task.result) {
                        val type = object : TypeToken<Map<String, Any>>() {}.type
                        list.add(gson.fromJson(gson.toJson(document.data, type), Recipe::class.java))
                        Timber.d(document.id + " => " + gson.toJson(document.data, type))
                    }
                    saveRecipes(list)
                } else {
                    Timber.d("Error getting documents: " + task.exception)
                }
            })
        }

        return recipes
    }

    fun saveRecipes(list: MutableList<Recipe>) {

        compositeDisposable.add(Observable.defer { Observable.just(dataManager.saveRecipes(list)) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it: List<Long>? ->
                    Timber.d("Inserted ${it?.size} records.")
                }, { it: Throwable? ->
                    Timber.e("Error : ${it?.message}")
                }))
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}