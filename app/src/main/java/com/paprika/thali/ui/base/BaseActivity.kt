package com.paprika.thali.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.paprika.thali.R

abstract class BaseActivity<V : BaseViewModel> : AppCompatActivity() {

    var viewModel: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }


}
