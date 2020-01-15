package com.mobile.droid.basekotlinapp.base

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

interface ResponseObserver<T> : Observer<T> {

    override fun onComplete() {

    }

    override fun onError(e: Throwable) {

    }

    override fun onNext(t: T) {

    }

    override fun onSubscribe(d: Disposable) {

    }
}