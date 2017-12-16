package com.paprika.thali.data.network

import com.paprika.thali.data.db.room.Recipe

/**
 * Created by vicky on 7/12/17.
 */
interface ApiHelper {

    fun getRecipes(): MutableList<Recipe>
}