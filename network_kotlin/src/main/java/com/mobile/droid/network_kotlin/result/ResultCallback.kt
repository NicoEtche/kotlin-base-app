package com.mobile.droid.network_kotlin.result

import com.mobile.droid.network_kotlin.error.HttpError

interface  ResultCallback<T> {
    fun onSuccess(result: T?)
    fun onFailure(error : HttpError)
    fun onNetworkerror()

  /*  data class Success<out T : Any>(val data: T) : Result<T>()
    data class Failure(val errorCode: Int, val desc: String) : Result<Nothing>()
    data class NetworkError(val exception : Exception) : Result<Nothing>()*/
}