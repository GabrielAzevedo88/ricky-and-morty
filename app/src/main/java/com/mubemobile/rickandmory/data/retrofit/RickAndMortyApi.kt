package com.mubemobile.rickandmory.data.retrofit

import com.mubemobile.rickandmory.data.model.CharacterResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character/")
    suspend fun getCharacters(@Query("page") page: Int): CharacterResult

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterResult.Character
}
