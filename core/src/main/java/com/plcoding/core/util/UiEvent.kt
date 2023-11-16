package com.plcoding.core.util

sealed class UiEvent {
    data class Navigate(val route: String): UiEvent()
    object NavigateUp: UiEvent()

    data class ShowSnakbar(val message: UiText): UiEvent()
}