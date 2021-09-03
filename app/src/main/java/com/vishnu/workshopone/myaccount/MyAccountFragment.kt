package com.vishnu.workshopone.myaccount

import android.os.Bundle
import android.view.View
import com.vishnu.core.base.BaseFragment
import com.vishnu.workshopone.BR
import com.vishnu.workshopone.R
import com.vishnu.workshopone.databinding.FragmentMyAccountBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyAccountFragment :
    BaseFragment<MyAccountViewModel, FragmentMyAccountBinding, MyAccountNavigator>() {

    private val viewModel: MyAccountViewModel by viewModel<MyAccountViewModel>()

    private val listener = object : MyAccountNavigator {

    }

    override fun layoutId(): Int = R.layout.fragment_my_account

    override fun bindingVariable(): Int = BR.viewModel

    override fun viewModel(): MyAccountViewModel = viewModel

    override fun getNavigator(): MyAccountNavigator = listener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel.observeDataSource()
        viewModel.getUser()
    }
}
