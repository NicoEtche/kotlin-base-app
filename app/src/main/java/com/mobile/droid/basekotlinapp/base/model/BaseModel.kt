package com.mobile.droid.basekotlinapp.base.model

import com.mobile.droid.basekotlinapp.base.ResponseObserver
import io.reactivex.Emitter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class BaseModel {

    /**
     * Function used to create a new observable for network requests
     * */
    fun <T> createResponseObservable(o : ResponseObserver<T>, result : T) {
        Observable.create { emitter: Emitter<T> ->
            emitter.onNext(result!!)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(o)
    }
}
