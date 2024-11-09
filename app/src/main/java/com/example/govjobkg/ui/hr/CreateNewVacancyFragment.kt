package com.example.govjobkg.ui.hr

import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.govjobkg.R
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentNewVacancyBinding

class CreateNewVacancyFragment : BaseFragment<MainHrViewModel, FragmentNewVacancyBinding>(
    FragmentNewVacancyBinding::inflate) {

    override val viewModel: MainHrViewModel by viewModels()


    override fun initClicks() {
        super.initClicks()
        binding.btnAddVacancy.setOnClickListener {
            findNavController().navigate(
                CreateNewVacancyFragmentDirections.actionCreateNewVacancyFragmentToSuccessFragment()
            )
        }
    }

    override fun initialize() = with(binding) {
        super.initialize()
        initToolbar()
        setUpDropDowns()

    }

    override fun observeViewModel() {
        super.observeViewModel()
    }

    private fun setUpDropDowns() = with(binding) {
        val sectors = resources.getStringArray(R.array.Sectors)
        val currencies = resources.getStringArray(R.array.Currencies)
        val jobs = resources.getStringArray(R.array.JobOptions)
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_drop_down_item,sectors)
        val currencyAdapter = ArrayAdapter(requireContext(), R.layout.simple_drop_down_item,currencies)
        val jobsAdapter = ArrayAdapter(requireContext(), R.layout.simple_drop_down_item,jobs)

        sectorDropDown.setAdapter(adapter)
        jobsDropDown.setAdapter(adapter)
        currencyDropDown.setAdapter(currencyAdapter)
        jobsDropDown.setAdapter(jobsAdapter)
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