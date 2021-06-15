package com.mubemobile.rickandmory.navigation

import androidx.navigation.NavHostController
import com.mubemobile.rickandmory.navigation.Navigation.CHARACTERS_SCREEN
import com.mubemobile.rickandmory.navigation.Navigation.CHARACTER_DETAIL_SCREEN

object Navigation {
    const val CHARACTERS_SCREEN = "characters"
    const val CHARACTER_DETAIL_SCREEN = "characterDetail/{id}"

    object CharacterDetailArgs {
        const val CHARACTER_ID = "id"
    }
}

class Actions(navController: NavHostController) {
    val openDetail: (Int) -> Unit =
        { id -> navController.navigate("$CHARACTER_DETAIL_SCREEN/${id}") }

    val openList: () -> Unit = {
        navController.navigate(CHARACTERS_SCREEN)
    }

    val navigateBack: () -> Unit = { navController.popBackStack() }
}