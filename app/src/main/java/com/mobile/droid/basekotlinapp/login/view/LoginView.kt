package com.mobile.droid.basekotlinapp.login.view

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.mobile.droid.basekotlinapp.R
import com.mobile.droid.basekotlinapp.base.view.BaseView
import io.reactivex.Emitter
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginView : BaseView() {

    lateinit var loginButton : Button
    lateinit var userField : EditText
    lateinit var passwordField : TextInputEditText
    lateinit var loginLogo : ImageView
    lateinit var loginVersionText : TextView
    lateinit var loginRecoverAccount : TextView

    override fun bindViews() {
        loginButton = context.findViewById(R.id.loginEnter)
        userField = context.findViewById(R.id.userEditText)
        passwordField = context.findViewById(R.id.passwordEditText)
        loginLogo = context.findViewById(R.id.loginLogo)
        loginVersionText = context.findViewById(R.id.loginVersionTextView)
        loginRecoverAccount = context.findViewById(R.id.loginRecoverAccount)
    }

    fun setClick(o : Observer<String>) {
        loginButton.setOnClickListener {
            Observable.create { emitter: Emitter<String> ->
                emitter.onNext("click")
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o)
        }
    }


}