package com.nguyen.demoproject.ui.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nguyen.demoproject.R
import com.nguyen.demoproject.databinding.FragmentListBinding
import com.nguyen.demoproject.utils.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentListBinding.inflate(inflater, container, false)

        subscribeObservers(binding)

        viewModel.getItems()

        return binding.root
    }

    private fun subscribeObservers(binding: FragmentListBinding){
        viewModel.itemsUIState.observe(viewLifecycleOwner, {state ->
            when(state){
                is UIState.Initial -> {

                }
                is UIState.Loading -> {

                }
                is UIState.Error -> {
                    Toast.makeText(requireContext(), "Error: ${state.errorMsg}", Toast.LENGTH_SHORT).show()
                }
                is UIState.Loaded -> {
                    state.value?.let{
                        Log.d("ListFragment", "items: $it")

                        val recyclerview = binding.listRecyclerview
                        recyclerview.adapter = ListRecycleViewAdapter(it)
                        recyclerview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                    }

                }

            }
        })
    }

}