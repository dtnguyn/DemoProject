package com.nguyen.demoproject.ui.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.nguyen.demoproject.R
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
        val view =  inflater.inflate(R.layout.fragment_list, container, false)

        subscribeObservers()

        viewModel.getItems()

        return view
    }

    private fun subscribeObservers(){
        viewModel.itemsUIState.observe(viewLifecycleOwner, {
            when(it){
                is UIState.Initial -> {

                }
                is UIState.Loading -> {

                }
                is UIState.Error -> {

                }
                is UIState.Loaded -> {
                    Log.d("ListFragment", "items: ${it.value}")
                }

            }
        })
    }

}