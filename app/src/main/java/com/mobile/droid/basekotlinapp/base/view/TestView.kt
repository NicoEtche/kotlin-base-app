package com.mobile.droid.basekotlinapp.base.view

import android.widget.TextView
import com.mobile.droid.basekotlinapp.R

class TestView : BaseView() {

    lateinit var textView: TextView


    override fun bindViews() {
        textView  = context.findViewById<TextView>(R.id.testText)
    }
}

