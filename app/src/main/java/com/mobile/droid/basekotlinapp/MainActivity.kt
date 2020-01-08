package com.mobile.droid.basekotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mobile.droid.network_kotlin.api.TestResponse
import com.mobile.droid.network_kotlin.error.HttpError
import com.mobile.droid.network_kotlin.repository.TestRepository
import com.mobile.droid.network_kotlin.result.ResultCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        scope.launch {
            getTest()
        }
    }

    suspend fun getTest() {
        TestRepository().getTest(object : ResultCallback<TestResponse> {
            override fun onSuccess(result: TestResponse?) {
                val testMessage = result?.test
                return
            }

            override fun onFailure(error: HttpError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onNetworkerror() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}
