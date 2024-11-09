package com.example.govjobkg.ui.user.resume

import androidx.fragment.app.viewModels
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentResumeBinding

class ResumeFragment : BaseFragment<ResumeViewModel, FragmentResumeBinding>(FragmentResumeBinding::inflate) {

    override val viewModel: ResumeViewModel by viewModels()


}