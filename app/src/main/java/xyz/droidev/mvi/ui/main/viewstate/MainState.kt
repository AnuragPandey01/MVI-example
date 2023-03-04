package xyz.droidev.mvi.ui.main.viewstate

import xyz.droidev.mvi.data.model.User


sealed class MainState {

    object Idle : MainState()
    object Loading : MainState()
    data class Users(val user: List<User>) : MainState()
    data class Error(val error: String?) : MainState()

}