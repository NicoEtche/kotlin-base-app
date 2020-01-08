package com.mobile.droid.network_kotlin.repository

import com.mobile.droid.network_kotlin.api.TestApi
import com.mobile.droid.network_kotlin.api.TestResponse
import com.mobile.droid.network_kotlin.result.ResultCallback

class TestRepository : BaseRepository<TestApi>(TestApi::class.java) {

    suspend fun getTest(resultCallback: ResultCallback<TestResponse>) {
        call({ api!!.getTest().await() }, resultCallback)
    }
}