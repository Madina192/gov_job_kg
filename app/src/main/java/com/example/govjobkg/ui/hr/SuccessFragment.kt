package com.example.govjobkg.ui.hr

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.govjobkg.R
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentSuccessBinding
import com.example.govjobkg.ui.MainViewModel

class SuccessFragment : BaseFragment<MainViewModel, FragmentSuccessBinding>(
    FragmentSuccessBinding::inflate) {

    override val viewModel: MainViewModel by viewModels()

    override fun initClicks() = with(binding) {
        super.initClicks()
        btnHome.setOnClickListener {
            findNavController().popBackStack(
                R.id.homeFragment,false
            )
        }
    }

    override fun initialize() {
        super.initialize()
    }



}