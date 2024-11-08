package com.example.govjobkg.ui.user.vacancies

import androidx.fragment.app.viewModels
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentVacanciesBinding

class VacanciesFragment : BaseFragment<VacanciesViewModel, FragmentVacanciesBinding>(FragmentVacanciesBinding::inflate) {

    override val viewModel: VacanciesViewModel by viewModels()

}