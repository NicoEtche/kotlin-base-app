package com.mobile.droid.network_kotlin.api

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface TestApi {
    @GET("/")
    fun getTest(): Deferred<Response<TestResponse>>
}
