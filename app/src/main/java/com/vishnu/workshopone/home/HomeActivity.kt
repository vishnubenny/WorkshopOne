package com.vishnu.workshopone.home

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.vishnu.core.base.BaseActivity
import com.vishnu.workshopone.BR
import com.vishnu.workshopone.R
import com.vishnu.workshopone.databinding.ActivityHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding, HomeNavigator>() {

    private val homeViewModel: HomeViewModel by viewModel()

    private val listener = object : HomeNavigator {

    }

    private lateinit var navigationController: NavController

    override fun getLayoutResId(): Int = R.layout.activity_home

    override fun getViewModel(): HomeViewModel = homeViewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getNavigator(): HomeNavigator = listener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel.getUser()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navigationController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navigationController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navigationController.navigateUp()
    }
}
