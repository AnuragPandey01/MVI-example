package xyz.droidev.mvi.data.api

import xyz.droidev.mvi.data.model.User

interface ApiHelper {

    suspend fun getUsers(): List<User>

}