package com.manage.android.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.manage.android.ui.base.BaseFragment
import com.manage.fundamental.BR
import com.manage.fundamental.R
import com.manage.fundamental.databinding.FragmentMainBinding
import javax.inject.Inject

fun newInstance(categoryName: String): Fragment = MainFragment().apply {
    arguments = Bundle(1).apply {
        putString("category", categoryName)
    }
}

internal const val MAIN_FRAGMENT_TAG = "MAIN_FRAGMENT_TAG"

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override val getBindingVariable = BR.viewModel

    override val layoutId = R.layout.fragment_main

    private lateinit var mainViewModel: MainViewModel

    private lateinit var category: String

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun getViewModel(): MainViewModel {
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        return mainViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.run {
            category = getString("category", null)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text.text = category

    }
}