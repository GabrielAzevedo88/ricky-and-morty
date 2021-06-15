package com.mubemobile.rickandmory.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.mubemobile.rickandmory.navigation.Actions
import com.mubemobile.rickandmory.navigation.Navigation.CHARACTERS_SCREEN
import com.mubemobile.rickandmory.navigation.Navigation.CHARACTER_DETAIL_SCREEN
import com.mubemobile.rickandmory.navigation.Navigation.CharacterDetailArgs.CHARACTER_ID
import com.mubemobile.rickandmory.ui.detail.CharactersDetailScreen
import com.mubemobile.rickandmory.ui.detail.DetailViewModel
import com.mubemobile.rickandmory.ui.list.CharactersScreen
import com.mubemobile.rickandmory.ui.list.ListCharactersViewModel
import com.mubemobile.rickandmory.ui.ui.AppComposeTheme
import org.koin.android.ext.android.inject

class CharactersActivity : AppCompatActivity() {
    private val mainViewModel: ListCharactersViewModel by inject()
    private val detailViewModel: DetailViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val actions = remember(navController) { Actions(navController) }

            AppComposeTheme {
                NavHost(
                    navController = navController,
                    startDestination = CHARACTERS_SCREEN
                ) {
                    composable(route = CHARACTERS_SCREEN) {
                        CharactersScreen(
                            listCharactersViewModel = mainViewModel,
                            actions.openDetail
                        )
                    }

                    composable(
                        route = "${CHARACTER_DETAIL_SCREEN}/{$CHARACTER_ID}",
                        arguments = listOf(navArgument(CHARACTER_ID) {
                            type = NavType.StringType
                        })
                    ) {
                        CharactersDetailScreen(
                            viewModel = detailViewModel,
                            id = it.arguments?.getInt(CHARACTER_ID),
                            navigateUp = actions.navigateBack
                        )
                    }
                }
            }
        }
    }
}
