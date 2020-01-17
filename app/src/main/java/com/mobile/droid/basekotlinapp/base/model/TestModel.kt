package com.mobile.droid.basekotlinapp.base.model

import com.mobile.droid.basekotlinapp.base.observer.ResponseObserver
import com.mobile.droid.network_kotlin.api.TestResponse
import com.mobile.droid.network_kotlin.error.HttpError
import com.mobile.droid.network_kotlin.repository.TestRepository
import com.mobile.droid.network_kotlin.result.ResultCallback

class TestModel : BaseModel() {

    private val testRepository: TestRepository = TestRepository()

    suspend fun getTest(o : ResponseObserver<TestResponse?>) {
        testRepository.getTest(object : ResultCallback<TestResponse> {

            override fun onSuccess(result: TestResponse?) {
                createResponseObservable(o, result)
            }

            override fun onFailure(error: HttpError) {
            }

            override fun onNetworkerror() {
            }
        })
    }
}