package com.manage.android.ui.base

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.manage.android.ui.base.BaseFragment



abstract class BaseFragment<T: ViewDataBinding, V: ViewModel> : Fragment() {

    private lateinit var activity: BaseActivity<T, V>
    private lateinit var rootView: View
    protected lateinit var binding: T
    private lateinit var viewModel: V

    interface Callback {
        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}