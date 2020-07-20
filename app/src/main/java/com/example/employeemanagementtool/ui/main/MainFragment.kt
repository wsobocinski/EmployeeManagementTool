package com.example.employeemanagementtool.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employeemanagementtool.R
import com.example.employeemanagementtool.RecyclerViewAdapter
import com.example.employeemanagementtool.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {
    private val mainFragmentViewModel by viewModels<MainViewModel>()
    private lateinit var employeeAdapter: RecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding: MainFragmentBinding = DataBindingUtil
            .inflate(inflater, R.layout.main_fragment, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = mainFragmentViewModel
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            employeeAdapter = RecyclerViewAdapter()
            adapter = employeeAdapter
        }

        mainFragmentViewModel.getAllEmployees().observe(viewLifecycleOwner, Observer {
            employeeAdapter.submitList(it)
        })


        return binding.root
    }
}