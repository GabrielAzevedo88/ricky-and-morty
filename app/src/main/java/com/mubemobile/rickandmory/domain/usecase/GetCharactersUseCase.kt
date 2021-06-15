package com.mubemobile.rickandmory.domain.usecase

import com.mubemobile.rickandmory.domain.repository.CharacterRepository

class GetCharactersUseCase(private val characterRepository: CharacterRepository) {
    suspend fun execute() = characterRepository.getCharacters()
}
