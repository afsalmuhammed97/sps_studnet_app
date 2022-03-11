package com.practies.myapplication.di

import com.practies.myapplication.network.helper.Constants.BASE_URL
import com.practies.myapplication.network.repositories.TeacherRepository
import com.practies.myapplication.network.services.ApiServices
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun providesAPI(retrofit: Retrofit): ApiServices =
        retrofit.create(ApiServices::class.java)

    @Singleton
    @Provides
    fun providesRepository(apiServices: ApiServices) = TeacherRepository(apiServices)

}