package xyz.droidev.mvi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import xyz.droidev.mvi.data.api.ApiHelper
import xyz.droidev.mvi.data.api.ApiHelperImpl
import xyz.droidev.mvi.data.api.ApiService
import xyz.droidev.mvi.data.repository.MainRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideAPiService():ApiService{
        return Retrofit.Builder()
            .baseUrl("https://5e510330f2c0d300147c034c.mockapi.io/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiHelper(apiService: ApiService):ApiHelper{
        return ApiHelperImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideMainRepository(apiHelper: ApiHelper): MainRepository{
        return MainRepository(apiHelper)
    }
}