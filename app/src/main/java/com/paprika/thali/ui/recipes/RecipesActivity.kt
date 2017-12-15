package com.paprika.thali.ui.recipes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.paprika.thali.R
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
        recipesViewModel.getRecipesFromFirebase()
    }
}
