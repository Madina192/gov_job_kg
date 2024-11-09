package com.example.govjobkg.ui.user

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.govjobkg.R
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentUserHomeBinding
import com.example.govjobkg.network.models.Category
import com.example.govjobkg.ui.auth.AuthFragmentDirections
import com.example.govjobkg.ui.user.adapter.CategoryAdapter

class UserHomeFragment :
    BaseFragment<UserMainViewModel, FragmentUserHomeBinding>(FragmentUserHomeBinding::inflate) {

    override val viewModel: UserMainViewModel by viewModels()
    private val adapter = CategoryAdapter(this::onCategoryClick)

    override fun initialize() {
        super.initialize()
        initToolbar()
        binding.recyclerView.adapter = adapter
        adapter.setList(listOf(
            Category("Врач", R.drawable.img_doctor),
            Category("Преподаватель", R.drawable.img_teacher),
            Category("Инженер", R.drawable.img_engineer),
            Category("Полицейский", R.drawable.policeman),
            Category("Электрик", R.drawable.electrician),
            Category("Юрист", R.drawable.lawyer),
            Category("Менеджер", R.drawable.manager),
            Category("Программист", R.drawable.programmer),
            Category("Повар", R.drawable.cooking)
        ))
    }

    private fun initToolbar(){
        binding.toolbar.apply {
            ivBack.isVisible = false
            title.text = "Главная"
        }
    }

    private fun onCategoryClick(){
        findNavController().navigate(
            UserHomeFragmentDirections.actionHomeFragmentToVacanciesFragment()
        )
    }
}