package com.example.govjobkg.ui.user.main

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.govjobkg.R
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentUserMainBinding
import com.example.govjobkg.ui.user.UserMainViewModel
import com.example.govjobkg.util.gone
import com.example.govjobkg.util.visible

class UserMainFragment :
    BaseFragment<UserMainViewModel, FragmentUserMainBinding>(FragmentUserMainBinding::inflate) {

    override val viewModel: UserMainViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        initNavigation()
    }


    private fun initNavigation() {
        val navHostFragment = childFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id !in SHOW_BOTTOM_NAV_VIEW_LIST) {
                hideNavigationBar()
            } else {
                showNavigationBar()
            }
        }
    }

    private fun hideNavigationBar() {
        if (binding.bottomNavView.isVisible) {
            binding.bottomNavView.gone(true, 100)
        }
    }

    private fun showNavigationBar() {
        if (!binding.bottomNavView.isVisible) {
            binding.bottomNavView.visible(true)
        }
    }
    override fun observeViewModel() {
        super.observeViewModel()
    }
    companion object {

        private val SHOW_BOTTOM_NAV_VIEW_LIST = setOf(
            R.id.userHomeFragment,
            R.id.userSavedFragment,
            R.id.userApplicationsFragment,
            R.id.userProfileFragment,
        )
    }
}