package com.example.govjobkg.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.govjobkg.util.ServiceCallState
import com.example.govjobkg.util.serviceCallState

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(
    private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {


    private var loading = false

    private var _binding: VB? = null
    protected val binding
        get() = _binding!!

    protected abstract val viewModel: VM



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = bindingInflater.invoke(layoutInflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLoadingState()
        initialize()
        initClicks()
        observeViewModel()
    }

    protected open fun initialize() {

    }

    protected open fun initClicks() {}

    protected open fun observeViewModel() {

    }

    private fun observeLoadingState() {
        serviceCallState.observe(viewLifecycleOwner) {
            when (it) {
                ServiceCallState.LOADING -> {
                    onLoading(true)
                }
                else -> {
                    onLoading(false)
                }
            }
        }
    }


    protected open fun onLoading(loading: Boolean) {
        this.loading = loading

    }

    protected fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(requireContext(), message, length).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}