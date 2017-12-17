package com.paprika.thali.ui.recipes

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.paprika.thali.R
import com.paprika.thali.data.db.room.Recipe
import dagger.android.AndroidInjection
import javax.inject.Inject

class RecipesActivity : AppCompatActivity() {

    @Inject
    lateinit var recipesViewModel: RecipesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)
        init()

    }

    private fun init() {
        recipesViewModel.getRecipesFromFirebase()?.observe(this, Observer { it: List<Recipe>? -> Toast.makeText(this, "Got it.", Toast.LENGTH_SHORT).show() })
    }
}
