package com.mubemobile.rickandmory.ui.list

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mubemobile.rickandmory.R
import com.mubemobile.rickandmory.ui.composables.CharacterList

@Composable
fun CharactersScreen(listCharactersViewModel: ListCharactersViewModel, onClick: (Int) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.app_name))
                }
            )
        },
        content = {
            CharacterList(characters = listCharactersViewModel.getCharacters(), onClick = onClick)
        }
    )
}
