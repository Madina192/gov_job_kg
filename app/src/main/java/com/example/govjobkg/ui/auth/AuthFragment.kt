package com.example.govjobkg.ui.auth

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.govjobkg.R
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentAuthBinding

class AuthFragment : BaseFragment<AuthViewModel, FragmentAuthBinding>(FragmentAuthBinding::inflate) {

    override val viewModel: AuthViewModel by viewModels()


    override fun initialize() = with(binding) {
        super.initialize()
        //TODO check user role and  accordingly send to screens
        btnLoginUser.setOnClickListener {
            findNavController().navigate(
                AuthFragmentDirections.actionAuthFragmentToUserMainFragment()
            )
        }

        btnLoginAssHr.setOnClickListener {
            findNavController().navigate(
                AuthFragmentDirections.actionAuthFragmentToHrMainFragment()
            )
        }
    }



    override fun initClicks() {
        super.initClicks()
    }

    override fun observeViewModel() {
        super.observeViewModel()
      /*  viewModel.movies.observe(viewLifecycleOwner) {

        }*/
    }


    override fun onLoading(loading: Boolean) {
        super.onLoading(loading)
        binding.progress.isVisible = loading
    }
}