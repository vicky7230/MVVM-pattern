package com.paprika.thali.ui.recipes

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.paprika.thali.R
import com.paprika.thali.data.db.room.Recipe
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_recipes.*
import javax.inject.Inject

class RecipesActivity : AppCompatActivity() {

    @Inject
    lateinit var recipesViewModel: RecipesViewModel
    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager
    @Inject
    lateinit var recipesAdapter: RecipesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)
        init()
    }

    private fun init() {
        recipe_list.layoutManager = linearLayoutManager
        recipe_list.adapter = recipesAdapter
        recipesViewModel.getRecipesFromFirebase()?.observe(this, Observer { it: MutableList<Recipe>? ->
            run {
                //Toast.makeText(this, "Got it.", Toast.LENGTH_SHORT).show()
                recipesAdapter.addItems(it)
            }
        })
    }
}
