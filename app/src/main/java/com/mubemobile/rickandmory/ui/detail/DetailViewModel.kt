package com.mubemobile.rickandmory.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubemobile.rickandmory.domain.repository.CharacterRepository
import com.mubemobile.rickandmory.ui.model.Character
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: CharacterRepository) : ViewModel() {

    val characterDetail: MutableLiveData<Character> = MutableLiveData()
    fun dispatchAction(action: ViewAction) = when (action) {
        is ViewAction.Init -> getCharactersById(action.id)
    }

    private fun getCharactersById(id: Int) {
        viewModelScope.launch {
            val result = repository.getCharacterById(id)
            characterDetail.value = result.data
        }
    }
}

sealed class ViewAction {
    data class Init(val id: Int) : ViewAction()
}
