package com.paprika.thali.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import com.paprika.thali.R
import com.paprika.thali.utils.ValidationUtils
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        init()
    }

    private fun init() {

        val emailValidObservable: Observable<Boolean> = RxTextView.textChanges(email).map { charSequence ->
            ValidationUtils.isValidEmail(charSequence.toString())
        }

        val passwordValidObservable: Observable<Boolean> = RxTextView.textChanges(password).map { charSequence ->
            ValidationUtils.isValidPassword(charSequence.toString())
        }

        val loginEnabled: Observable<Boolean> = Observable.combineLatest(emailValidObservable, passwordValidObservable,
                BiFunction { validEmail: Boolean, validPassword: Boolean -> validEmail && validPassword })

        compositeDisposable.add(loginEnabled.subscribe({ boolean: Boolean -> login_button.isEnabled = boolean }))
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}
