package com.example.govjobkg.ui.auth

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentAuthBinding

class AuthFragment : BaseFragment<AuthViewModel, FragmentAuthBinding>(FragmentAuthBinding::inflate) {

    override val viewModel: AuthViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        viewModel.getMovies()
    }

    override fun initClicks() {
        super.initClicks()
    }

    override fun observeViewModel() {
        super.observeViewModel()
        viewModel.movies.observe(viewLifecycleOwner) {

        }
    }

    override fun onLoading(loading: Boolean) {
        super.onLoading(loading)
        binding.progress.isVisible = loading
    }
}