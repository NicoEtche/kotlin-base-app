package com.mobile.droid.basekotlinapp.base.model

import com.mobile.droid.basekotlinapp.base.observer.FailureObserver
import com.mobile.droid.basekotlinapp.base.observer.NetworkErrorObserver
import com.mobile.droid.basekotlinapp.base.observer.ResponseObserver
import io.reactivex.Emitter
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class BaseModel {

    /**
     * Function used to create a new observable
     * */
    private fun <T> createObservable(o: Observer<T>, result: T) {
        Observable.create { emitter: Emitter<T> ->
            emitter.onNext(result!!)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(o)
    }

    fun <T> createResponseObservable(o: ResponseObserver<T>, result: T) {
        createObservable(o, result)
    }

    fun <T> createFailureObservable(o: FailureObserver<T>, result: T) {
        createObservable(o, result)
    }

    fun <T> createNetworkErrorObservable(o: NetworkErrorObserver<T>, result: T) {
        createObservable(o, result)
    }
}
