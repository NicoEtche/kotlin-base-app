package com.mobile.droid.basekotlinapp.login.presenter

import android.os.Bundle
import android.widget.Toast
import com.mobile.droid.basekotlinapp.R
import com.mobile.droid.basekotlinapp.base.observer.FailureObserver
import com.mobile.droid.basekotlinapp.base.observer.NetworkErrorObserver
import com.mobile.droid.basekotlinapp.base.observer.ResponseObserver
import com.mobile.droid.basekotlinapp.base.presenter.BaseActivity
import com.mobile.droid.basekotlinapp.login.model.LoginModel
import com.mobile.droid.basekotlinapp.login.view.LoginView
import com.mobile.droid.network_kotlin.api.TestResponse
import com.mobile.droid.network_kotlin.error.HttpError
import kotlinx.coroutines.launch

class LoginActivity : BaseActivity<LoginModel, LoginView>(LoginModel(), LoginView()) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()
        setLoginClick()
    }

    private fun setLoginClick() {
        view.setClick(object :
            ResponseObserver<String> {

            override fun onNext(t: String) {
                scope.launch {
                    model.getTest(
                        object : ResponseObserver<TestResponse?> {
                            override fun onNext(t: TestResponse?) {
                                Toast.makeText(applicationContext, t?.test, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }, object : FailureObserver<HttpError> {
                            override fun onNext(t: HttpError) {
                                super.onNext(t)
                            }
                        }, object : NetworkErrorObserver<String> {
                            override fun onNext(t: String) {
                                Toast.makeText(
                                    applicationContext,
                                    "Network Error",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        })
                }
            }
        })
    }
}
