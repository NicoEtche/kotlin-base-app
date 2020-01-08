package com.mobile.droid.network_kotlin.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object ApiFactory {

    private val interceptor = Interceptor {
        chain ->
        //val newUrl to add headers, etc.
        val newUrl = chain
            .request()
            .url()
            .newBuilder()
            .build()

        val newRequest = chain
            .request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }


    private val httpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(interceptor)
        .build()

    fun createRetrofit() : Retrofit = Retrofit.Builder()
        .client(httpClient)
        .baseUrl("http://melkorjfv.pythonanywhere.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}