package com.mobile.droid.basekotlinapp.base.view

import androidx.appcompat.app.AppCompatActivity

abstract class BaseView {
    lateinit var context: AppCompatActivity

    fun prepareView(contextActivity: AppCompatActivity) {
        context = contextActivity
        bindViews()
    }

    abstract fun bindViews()
}

