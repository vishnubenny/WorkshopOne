package com.vishnu.workshopone.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class SampleJobService : JobService() {

    private val scope: CoroutineScope

    init {
        scope = this.setScope()
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        params?.extras?.let {
            val test = it.getString("test", "")
            Log.e("param", test)
        }
        scope.launch {
            flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect {
                    Log.e("test", "log $it")
                    delay(2000)
                }
        }
        return false
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        scope.cancel()
        return false
    }

    fun setScope(): CoroutineScope {
        return GlobalScope
    }
}
