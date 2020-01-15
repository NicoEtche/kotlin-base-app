package com.mobile.droid.basekotlinapp.base.presenter

import androidx.appcompat.app.AppCompatActivity
import com.mobile.droid.basekotlinapp.base.model.BaseModel
import com.mobile.droid.basekotlinapp.base.view.BaseView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity<M: BaseModel, V: BaseView>(val model: M, val view : V) : AppCompatActivity() {

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    val scope = CoroutineScope(coroutineContext)

    override fun onStart() {
        super.onStart()
        view.prepareView(this)
    }
}
