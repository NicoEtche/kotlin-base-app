package com.mobile.droid.network_kotlin.repository

import com.mobile.droid.network_kotlin.error.HttpError
import com.mobile.droid.network_kotlin.result.ResultCallback
import com.mobile.droid.network_kotlin.service.ApiFactory
import retrofit2.Response
import java.net.UnknownHostException

abstract class BaseRepository<API>(apiClass: Class<API>) {

    protected var api: API? = ApiFactory.createRetrofit().create(apiClass)

    suspend fun <R> call(call: suspend () -> Response<R>, resultCallback: ResultCallback<R>) {
       try {
           val response = call.invoke()
           if (response.isSuccessful) {
               resultCallback.onSuccess(response.body()!!)
               return
           }
       } catch (e :UnknownHostException) {
           print("asdasdasdasdasdas")
       }

        //resultCallback.onFailure(HttpError(response.code(), "Failed, specify your error details"))
    }
}
