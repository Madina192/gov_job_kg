package com.example.govjobkg.ui.hr

import androidx.fragment.app.viewModels
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentApplicationsBinding

class ApplicationsFragment : BaseFragment<MainHrViewModel, FragmentApplicationsBinding>(FragmentApplicationsBinding::inflate) {

    override val viewModel: MainHrViewModel by viewModels()


    override fun initialize() {
        super.initialize()
    }

    override fun initClicks() {
        super.initClicks()
    }

    override fun observeViewModel() {
        super.observeViewModel()
    }

    override fun onLoading(loading: Boolean) {
        super.onLoading(loading)
    }

}