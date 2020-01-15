package com.mobile.droid.basekotlinapp.base.model

import com.mobile.droid.network_kotlin.api.TestResponse
import com.mobile.droid.network_kotlin.error.HttpError
import com.mobile.droid.network_kotlin.repository.TestRepository
import com.mobile.droid.network_kotlin.result.ResultCallback
import io.reactivex.Emitter
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TestModel : BaseModel() {

    private val testRepository: TestRepository = TestRepository()

    suspend fun getTest(o : Observer<TestResponse>) {
        testRepository.getTest(object : ResultCallback<TestResponse> {

            override fun onSuccess(result: TestResponse?) {
                Observable.create { emitter: Emitter<TestResponse> ->
                    emitter.onNext(result!!)
                }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(o)
            }

            override fun onFailure(error: HttpError) {
            }

            override fun onNetworkerror() {
            }
        })
    }
}