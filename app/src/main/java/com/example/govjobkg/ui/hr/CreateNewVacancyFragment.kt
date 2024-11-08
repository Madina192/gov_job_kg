package com.example.govjobkg.ui.hr

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentNewVacancyBinding

class CreateNewVacancyFragment : BaseFragment<MainHrViewModel, FragmentNewVacancyBinding>(
    FragmentNewVacancyBinding::inflate) {

    override val viewModel: MainHrViewModel by viewModels()


    override fun initClicks() {
        super.initClicks()
    }

    override fun initialize() {
        super.initialize()
        initToolbar()
    }

    override fun observeViewModel() {
        super.observeViewModel()
    }

    private fun initToolbar() {
        with(binding) {
            toolbar.apply {
                ivBack.setOnClickListener {
                    findNavController().navigateUp()
                }
                title.text = "Новая вакансия"
            }
        }
    }

}