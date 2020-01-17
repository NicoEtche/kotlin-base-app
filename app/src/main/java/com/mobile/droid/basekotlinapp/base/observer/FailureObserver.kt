package com.mobile.droid.basekotlinapp.base.observer

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

interface FailureObserver<T>: Observer<T> {

    override fun onComplete() {

    }

    override fun onError(e: Throwable) {

    }

    override fun onNext(t: T) {

    }

    override fun onSubscribe(d: Disposable) {

    }
}