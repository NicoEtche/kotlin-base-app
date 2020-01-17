package com.mobile.droid.basekotlinapp.base.presenter

import android.os.Bundle
import com.mobile.droid.basekotlinapp.R
import com.mobile.droid.basekotlinapp.base.ResponseObserver
import com.mobile.droid.basekotlinapp.base.model.TestModel
import com.mobile.droid.basekotlinapp.base.view.TestView
import com.mobile.droid.network_kotlin.api.TestResponse
import kotlinx.coroutines.launch

class TestActivity : BaseActivity<TestModel, TestView>(TestModel(), TestView()) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        printMessage()
    }

    private fun printMessage() {
        scope.launch {
            model.getTest(object : ResponseObserver<TestResponse?> {
                override fun onNext(t: TestResponse?) {
                    view.textView.text = t?.test
                }
            })
        }
    }
}
