package com.example.govjobkg.ui.user

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentUserApplicationsBinding
import com.example.govjobkg.ui.MainViewModel


class UserApplicationsFragment : BaseFragment<MainViewModel, FragmentUserApplicationsBinding>(
    FragmentUserApplicationsBinding::inflate) {

    override val viewModel: MainViewModel by viewModels()

    override fun initClicks() = with(binding) {
        super.initClicks()
    }

    override fun initialize() {
        super.initialize()
        initToolbar()
    }



    private fun initToolbar(){
        binding.toolbar.apply {
            ivBack.isVisible = false
            title.text = "Мои отклики"
        }
    }
}