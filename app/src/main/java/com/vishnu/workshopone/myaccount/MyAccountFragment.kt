package com.vishnu.workshopone.myaccount

import com.vishnu.core.base.BaseFragment
import com.vishnu.workshopone.BR
import com.vishnu.workshopone.R
import com.vishnu.workshopone.databinding.FragmentMyAccountBinding

class MyAccountFragment :
    BaseFragment<MyAccountViewModel, FragmentMyAccountBinding, MyAccountNavigator>() {

    private val listener = object : MyAccountNavigator {

    }

    override fun layoutId(): Int = R.layout.fragment_my_account

    override fun bindingVariable(): Int = BR.viewModel

    override fun viewModel(): MyAccountViewModel = MyAccountViewModel()

    override fun getNavigator(): MyAccountNavigator = listener
}
