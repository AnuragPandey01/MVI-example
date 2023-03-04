package xyz.droidev.mvi.data.repository

import xyz.droidev.mvi.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()

}