package com.nguyen.demoproject.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguyen.demoproject.model.Item
import com.nguyen.demoproject.repo.HiringRepository
import com.nguyen.demoproject.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel
@Inject constructor (
    private val repo: HiringRepository,
): ViewModel() {

    private val _itemsUIState = MutableLiveData<UIState<List<Item>>>(UIState.Initial(listOf()))
    val itemsUIState = _itemsUIState

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getItems(){

        viewModelScope.launch {
            repo.getItems().collectLatest {
                _itemsUIState.value = it
            }
        }
    }

}