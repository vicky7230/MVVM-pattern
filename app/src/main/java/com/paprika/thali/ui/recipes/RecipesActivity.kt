package com.paprika.thali.ui.recipes

import android.os.Bundle
import com.paprika.thali.R
import com.paprika.thali.ui.base.BaseActivity

class RecipesActivity : BaseActivity<>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)
    }
}
