package com.mubemobile.rickandmory.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mubemobile.rickandmory.ui.composables.CharacterImage
import com.mubemobile.rickandmory.ui.composables.CharacterName

@Composable
fun CharactersDetailScreen(viewModel: DetailViewModel, id: Int?, navigateUp: () -> Unit) {
    val characterId = id ?: 0
    viewModel.dispatchAction(ViewAction.Init(characterId))
    val personage = viewModel.characterDetail.observeAsState()

    personage.value?.let { character ->
        Scaffold(topBar = {
            TopAppBar(
                title = {
                    Text(character.name)
                },
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(Icons.Rounded.ArrowBack, "")
                    }
                }
            )
        }, content = {
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CharacterImage(
                    imageUrl = character.image,
                    modifier = Modifier.padding(end = 16.dp)
                )
                CharacterName(
                    character.name,
                    modifier = Modifier.weight(1f)
                )
            }
        })
    }
}
