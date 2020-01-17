package com.mobile.droid.basekotlinapp.login.model

import com.mobile.droid.basekotlinapp.base.ResponseObserver
import com.mobile.droid.basekotlinapp.base.model.BaseModel
import com.mobile.droid.network_kotlin.api.TestResponse
import com.mobile.droid.network_kotlin.error.HttpError
import com.mobile.droid.network_kotlin.repository.TestRepository
import com.mobile.droid.network_kotlin.result.ResultCallback


class LoginModel : BaseModel() {

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