package com.mubemobile.rickandmory.di

import com.mubemobile.rickandmory.data.CharacterRepositoryImpl
import com.mubemobile.rickandmory.domain.repository.CharacterRepository
import com.mubemobile.rickandmory.domain.usecase.GetCharactersUseCase
import com.mubemobile.rickandmory.ui.detail.DetailViewModel
import com.mubemobile.rickandmory.ui.list.ListCharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ListCharactersViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    factory<CharacterRepository> { CharacterRepositoryImpl(get()) }
    factory { GetCharactersUseCase(get()) }
}
