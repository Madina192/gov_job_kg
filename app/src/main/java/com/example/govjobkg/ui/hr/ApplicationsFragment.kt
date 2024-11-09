package com.example.govjobkg.ui.hr

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentApplicationsBinding

class ApplicationsFragment : BaseFragment<MainHrViewModel, FragmentApplicationsBinding>(FragmentApplicationsBinding::inflate) {

    override val viewModel: MainHrViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        initToolbar()
    }

    override fun initClicks() {
        super.initClicks()
    }

    override fun observeViewModel() {
        super.observeViewModel()
    }


    private fun initToolbar(){
        binding.toolbar.apply {
            ivBack.isVisible = false
            title.text = "Отклики"
        }
    }

}