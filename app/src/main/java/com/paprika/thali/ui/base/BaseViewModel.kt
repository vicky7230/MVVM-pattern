package com.paprika.thali.ui.base

import android.arch.lifecycle.ViewModel
import com.paprika.thali.data.DataManager
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by vicky on 10/12/17.
 */

abstract class BaseViewModel<N>
@Inject constructor(val dataManager: DataManager, val compositeDisposable: CompositeDisposable) : ViewModel() {

    var navigator: N? = null

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}