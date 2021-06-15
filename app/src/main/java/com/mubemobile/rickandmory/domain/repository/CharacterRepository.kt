package com.mubemobile.rickandmory.domain.repository

import androidx.paging.PagingData
import com.mubemobile.rickandmory.network.Resource
import com.mubemobile.rickandmory.ui.model.CharacterUi
import com.mubemobile.rickandmory.ui.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacters(page: Int = 1): Resource<List<CharacterUi>>
    fun getCharactersPager(): Flow<PagingData<CharacterUi>>
    suspend fun getCharacterById(id: Int): Resource<Character>
}
