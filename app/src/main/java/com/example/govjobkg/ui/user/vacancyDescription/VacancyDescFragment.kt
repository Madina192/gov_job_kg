package com.example.govjobkg.ui.user.vacancyDescription

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentVacancyDescBinding

class VacancyDescFragment : BaseFragment<VacancyDescViewModel, FragmentVacancyDescBinding>(FragmentVacancyDescBinding::inflate) {

    override val viewModel: VacancyDescViewModel by viewModels()

    override fun initClicks() {
        super.initClicks()

        binding.btnLoginAssHr.setOnClickListener {
            findNavController().navigate(
                VacancyDescFragmentDirections.actionVacancyDescFragmentToResumeFragment()
            )
        }
    }

}