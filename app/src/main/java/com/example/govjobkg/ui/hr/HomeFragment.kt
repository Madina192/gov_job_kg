package com.example.govjobkg.ui.hr

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentHomeBinding
import com.example.govjobkg.ui.MainViewModel

class HomeFragment : BaseFragment<MainViewModel, FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val viewModel: MainViewModel by viewModels()

    override fun initClicks() = with(binding) {
        super.initClicks()
        btnAdd.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToCreateNewVacancyFragment()
            )

        }
    }

    override fun initialize() {
        super.initialize()
        initToolbar()
    }



    private fun initToolbar(){
        binding.toolbar.apply {
            ivBack.isVisible = false
            title.text = "Главная"
        }
    }
}