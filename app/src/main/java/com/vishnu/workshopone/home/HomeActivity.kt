package com.vishnu.workshopone.home

import android.os.Bundle
import com.vishnu.core.base.BaseActivity
import com.vishnu.workshopone.BR
import com.vishnu.workshopone.R
import com.vishnu.workshopone.databinding.ActivityHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding, HomeNavigator>() {

    private val homeViewModel: HomeViewModel by viewModel()

    private val listener = object : HomeNavigator {

    }

    override fun getLayoutResId(): Int = R.layout.activity_home

    override fun getViewModel(): HomeViewModel = homeViewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getNavigator(): HomeNavigator = listener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel.getUser()
    }
}
