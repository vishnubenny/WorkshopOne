package com.vishnu.core.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<V : BaseViewModel<N>, T : ViewDataBinding, N : BaseNavigator>
    : AppCompatActivity() {

    private lateinit var viewDataBinding: T
    private lateinit var viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutResId())
        viewModel = getViewModel()
        viewModel.setNavigator(getNavigator())
        viewDataBinding.setVariable(getBindingVariable(), viewModel)
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.executePendingBindings()
    }

    @LayoutRes
    abstract fun getLayoutResId(): Int

    abstract fun getViewModel(): V

    abstract fun getBindingVariable(): Int

    abstract fun getNavigator(): N
}
