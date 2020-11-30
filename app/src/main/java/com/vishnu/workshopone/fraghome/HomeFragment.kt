package com.vishnu.workshopone.fraghome

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.vishnu.core.base.BaseFragment
import com.vishnu.workshopone.BR
import com.vishnu.workshopone.R
import com.vishnu.workshopone.databinding.FragmentHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment :
    BaseFragment<HomeFragmentViewModel, FragmentHomeBinding, HomeFragmentNavigator>() {

    private val viewModel: HomeFragmentViewModel by viewModel<HomeFragmentViewModel>()

    private val listener = object : HomeFragmentNavigator {
        override fun getContext(): Context {
            return this@HomeFragment.requireContext()
        }
    }

    override fun layoutId(): Int = R.layout.fragment_home

    override fun bindingVariable(): Int = BR.viewModel

    override fun viewModel(): HomeFragmentViewModel = viewModel

    override fun getNavigator(): HomeFragmentNavigator = listener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
    }

    private fun setUpView(view: View) {
        val navController = Navigation.findNavController(view)
        viewModel.showFragment2Event()
            .observe(this, {
                navController.navigate(R.id.action_homeFragment_to_myAccountFragment2)
            })
    }
}
