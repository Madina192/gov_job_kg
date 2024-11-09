package com.example.govjobkg.ui.user

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentUserApplicationsBinding
import com.example.govjobkg.ui.user.vacancies.VacanciesAdapter
import com.example.govjobkg.ui.user.vacancies.VacanciesFragmentDirections
import com.example.govjobkg.ui.user.vacancies.VacanciesViewModel
import kotlinx.coroutines.launch


class UserApplicationsFragment : BaseFragment<VacanciesViewModel, FragmentUserApplicationsBinding>(
    FragmentUserApplicationsBinding::inflate) {

    override val viewModel: VacanciesViewModel by viewModels()
    private val adapter = VacanciesAdapter(this::onVacancyClick)
    override fun initClicks() = with(binding) {
        super.initClicks()
    }

    override fun initialize() {
        super.initialize()
        lifecycleScope.launch {
            viewModel.getJobs()
        }

        binding.recyclerView.adapter = adapter
        initToolbar()
    }

    override fun observeViewModel() {
        super.observeViewModel()

        viewModel.getJobs.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }
    }



    private fun initToolbar(){
        binding.toolbar.apply {
            ivBack.isVisible = false
            title.text = "Мои отклики"
        }
    }

    private fun onVacancyClick(){
        findNavController().navigate(
            VacanciesFragmentDirections.actionVacanciesToVacancyDescFragment()
        )
    }
}