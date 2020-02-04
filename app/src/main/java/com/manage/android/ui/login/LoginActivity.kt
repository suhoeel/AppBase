package com.manage.android.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.manage.android.ui.base.BaseActivity
import com.manage.android.ui.main.MainViewModel
import com.manage.android.utils.reAskToTerminate
import com.manage.fundamental.BR
import com.manage.fundamental.R
import com.manage.fundamental.databinding.ActivityLoginBinding
import javax.inject.Inject


fun newIntent(context: Context): Intent = Intent(context, LoginActivity::class.java)

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override val layoutId: Int = R.layout.activity_login

    override val getBindingVariable: Int = BR.viewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun getViewModel(): LoginViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onBackPressed() {
        reAskToTerminate()
    }
}
