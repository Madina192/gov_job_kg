package com.example.govjobkg.ui.hr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.govjobkg.R
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentApplicantsListBinding
import com.example.govjobkg.ui.user.resume.ResumeViewModel


class ApplicantsListFragment : BaseFragment<ResumeViewModel, FragmentApplicantsListBinding>(FragmentApplicantsListBinding::inflate) {

    override val viewModel: ResumeViewModel by viewModels()


}