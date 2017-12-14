package com.paprika.thali.ui.base

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.paprika.thali.R
import com.paprika.thali.utils.CommonUtils
import dagger.android.AndroidInjection
import javax.inject.Inject
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat
import android.os.Build
import android.annotation.TargetApi


abstract class BaseActivity<V : BaseViewModel<BaseNavigator>> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: V

    private var progressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    fun showLoading() {
        hideLoading()
        progressDialog = CommonUtils.showLoadingDialog(this)
    }

    fun hideLoading() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog?.cancel()
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermissions(permissions: Array<String>): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true
        return permissions.none { ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED }
    }
}
