package com.mubemobile.rickandmory.ui

sealed class ViewAction {
    object Init : ViewAction()
    object Refresh : ViewAction()
}
