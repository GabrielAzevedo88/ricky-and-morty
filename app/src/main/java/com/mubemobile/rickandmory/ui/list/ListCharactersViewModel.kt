package com.mubemobile.rickandmory.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mubemobile.rickandmory.domain.repository.CharacterRepository
import com.mubemobile.rickandmory.ui.model.CharacterUi
import kotlinx.coroutines.flow.Flow

class ListCharactersViewModel(
    private val repository: CharacterRepository
) : ViewModel() {

    fun getCharacters(): Flow<PagingData<CharacterUi>> {
        return repository.getCharactersPager().cachedIn(viewModelScope)
    }
}
