package com.example.govjobkg.ui.user.vacancies

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentVacanciesBinding
import com.example.govjobkg.ui.user.UserHomeFragmentDirections

class VacanciesFragment : BaseFragment<VacanciesViewModel, FragmentVacanciesBinding>(FragmentVacanciesBinding::inflate) {

    override val viewModel: VacanciesViewModel by viewModels()
    private val adapter = VacanciesAdapter(this::onVacancyClick)

    override fun initialize() {
        super.initialize()

        binding.recyclerView.adapter = adapter
    }

    private fun onVacancyClick(){
        findNavController().navigate(
            VacanciesFragmentDirections.actionVacanciesToVacancyDescFragment()
        )
    }

}