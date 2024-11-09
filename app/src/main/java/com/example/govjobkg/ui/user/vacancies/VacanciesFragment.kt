package com.example.govjobkg.ui.user.vacancies

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentVacanciesBinding
import kotlinx.coroutines.launch

class VacanciesFragment : BaseFragment<VacanciesViewModel, FragmentVacanciesBinding>(FragmentVacanciesBinding::inflate) {

    override val viewModel: VacanciesViewModel by viewModels()
    private val adapter = VacanciesAdapter(this::onVacancyClick)

    override fun initialize() {
        super.initialize()
        lifecycleScope.launch {
            viewModel.getJobs()
        }

        binding.recyclerView.adapter = adapter
    }

    private fun onVacancyClick(){
        findNavController().navigate(
            VacanciesFragmentDirections.actionVacanciesToVacancyDescFragment()
        )
    }

    override fun observeViewModel() {
        super.observeViewModel()

        viewModel.getJobs.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }
    }

}