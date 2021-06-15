package com.mubemobile.rickandmory.data

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.Page
import androidx.paging.PagingState
import com.mubemobile.rickandmory.data.model.toCharacters
import com.mubemobile.rickandmory.data.retrofit.RickAndMortyApi
import com.mubemobile.rickandmory.ui.model.CharacterUi
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

class CharacterDataSource(
    private val api: RickAndMortyApi
) : PagingSource<Int, CharacterUi>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterUi> {
        return try {
            val result = api.getCharacters(params.key ?: STARTING_PAGE_INDEX).toCharacters()

            Page(
                data = result,
                prevKey = params.key,
                nextKey = params.key?.inc() ?: STARTING_PAGE_INDEX.inc()
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterUi>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.inc()
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.inc()
        }
}
