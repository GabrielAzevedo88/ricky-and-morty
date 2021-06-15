package com.mubemobile.rickandmory.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mubemobile.rickandmory.data.model.toCharacters
import com.mubemobile.rickandmory.data.retrofit.RickAndMortyApi
import com.mubemobile.rickandmory.domain.repository.CharacterRepository
import com.mubemobile.rickandmory.network.Resource
import com.mubemobile.rickandmory.ui.model.CharacterUi
import com.mubemobile.rickandmory.ui.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class CharacterRepositoryImpl(
    private val api: RickAndMortyApi
) : CharacterRepository {
    override suspend fun getCharacters(page: Int) = withContext(Dispatchers.IO) {
        try {
            val result = api.getCharacters(page)
            Resource.Success(result.toCharacters())
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    override fun getCharactersPager(): Flow<PagingData<CharacterUi>> {
        return Pager(
            config = PagingConfig(pageSize = 20, maxSize = 500),
            pagingSourceFactory = { CharacterDataSource(api) }
        ).flow
    }

    override suspend fun getCharacterById(id: Int) = withContext(Dispatchers.IO) {
        try {
            val result = api.getCharacterById(id)
            Resource.Success(Character(id = result.id, image = result.image, name = result.name))
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}
