package com.vishnu.core.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<V : BaseViewModel<N>, T : ViewDataBinding, N : BaseNavigator> :
    Fragment() {

    private lateinit var viewDataBinding: T
    private lateinit var viewModel: V
    private lateinit var activity: BaseActivity<*, *, *>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *, *>) activity = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModel()
        viewModel.setNavigator(getNavigator())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.setVariable(bindingVariable(), viewModel)
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.executePendingBindings()
    }

    abstract fun viewModel(): V

    @LayoutRes
    abstract fun layoutId(): Int

    abstract fun bindingVariable(): Int

    abstract fun getNavigator(): N

}
