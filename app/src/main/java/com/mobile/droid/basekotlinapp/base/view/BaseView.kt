package com.mobile.droid.basekotlinapp.base.view

import androidx.appcompat.app.AppCompatActivity

abstract class BaseView {
    lateinit var context: AppCompatActivity

    /**
     * Make possible the view binding by setting the context before
     * */
    fun prepareView(contextActivity: AppCompatActivity) {
        context = contextActivity
        bindViews()
    }

    /**
     * Use this function to bind all your activity.xml views, remember to declare them before like this:
     * lateinit var foo : Foo
     * */
    abstract fun bindViews()
}

