package com.example.govjobkg.ui.user.main

import androidx.fragment.app.viewModels
import com.example.govjobkg.R
import com.example.govjobkg.base.BaseFragment
import com.example.govjobkg.databinding.FragmentUserMainBinding
import com.example.govjobkg.network.models.Category

class UserMainFragment :
    BaseFragment<UserMainViewModel, FragmentUserMainBinding>(FragmentUserMainBinding::inflate) {

    override val viewModel: UserMainViewModel by viewModels()
    private val adapter = UserMainAdapter()

    override fun initialize() {
        super.initialize()

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
            Category("Повар", R.drawable.cooking),
        ))
    }
}