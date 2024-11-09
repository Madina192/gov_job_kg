package com.example.govjobkg.ui.user

import androidx.fragment.app.viewModels
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentUserSuccessBinding
import com.example.govjobkg.ui.MainViewModel

class UserSuccessFragment : BaseFragment<MainViewModel, FragmentUserSuccessBinding>(
    FragmentUserSuccessBinding::inflate) {

    override val viewModel: MainViewModel by viewModels()

    override fun initClicks() = with(binding) {
        super.initClicks()
        btnHome.setOnClickListener {
            UserSuccessFragmentDirections.actionSuccessFragment2ToUserApplicationsFragment()
        }
    }

    override fun initialize() {
        super.initialize()
    }



}