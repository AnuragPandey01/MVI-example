package xyz.droidev.mvi.data.api

import retrofit2.http.GET
import xyz.droidev.mvi.data.model.User

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>
}