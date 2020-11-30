package com.vishnu.workshopone.fraghome

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context.JOB_SCHEDULER_SERVICE
import android.os.Build
import android.os.PersistableBundle
import androidx.annotation.RequiresApi
import com.vishnu.core.base.BaseViewModel
import com.vishnu.workshopone.common.util.SingleLiveEvent
import com.vishnu.workshopone.jobscheduler.SampleJobService

class HomeFragmentViewModel(private val jobService: SampleJobService) :
    BaseViewModel<HomeFragmentNavigator>() {

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            jobService.setScope()
        }
    }

    private val showFragment2Event = SingleLiveEvent<Any>()

    fun showFragment2Event(): SingleLiveEvent<Any> = showFragment2Event

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun onShowFragment2Clicked() {
//        showFragment2Event.call()
        navigator()?.getContext()?.let {
            val name = ComponentName(it, SampleJobService::class.java)
            val bundle = PersistableBundle()
            bundle.putString("test", "test")
            val builder = JobInfo.Builder(101, name)
                .setExtras(bundle)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000)

            val scheduler = it.getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            scheduler.schedule(builder.build())
        }
    }
}
