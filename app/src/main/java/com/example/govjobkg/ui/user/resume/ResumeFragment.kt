package com.example.govjobkg.ui.user.resume

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.network.models.Resume
import kotlinx.coroutines.launch
import com.example.govjobkg.databinding.FragmentResumeBinding

class ResumeFragment : BaseFragment<ResumeViewModel, FragmentResumeBinding>(FragmentResumeBinding::inflate) {

    override val viewModel: ResumeViewModel by viewModels()

    override fun initClicks() {
        super.initClicks()

        binding.btnCreate.setOnClickListener {
            lifecycleScope.launch {
                viewModel.createResume(Resume(binding.etUserName.text.toString(), binding.etBirthday.text.toString(), binding.etJobTitle.text.toString(), binding.etEducation.text.toString(), binding.etExperience.text.toString(), binding.etPhone.text.toString()))
            }
        }
    }

    override fun observeViewModel() {
        super.observeViewModel()

        viewModel.createResumeResponse.observe(viewLifecycleOwner) {
            findNavController().navigate(
                ResumeFragmentDirections.actionResumeFragmentToSuccessFragment2()
            )
        }
    }


}