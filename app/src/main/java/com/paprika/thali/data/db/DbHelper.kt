package com.paprika.thali.data.db

import com.paprika.thali.data.db.room.Recipe

/**
 * Created by vicky on 7/12/17.
 */
interface DbHelper {

    fun saveRecipes(list: MutableList<Recipe>): List<Long>
}