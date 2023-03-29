package com.example.hiltdependencyinjection.di

import com.example.hiltdependencyinjection.repository.MainRepository
import com.example.hiltdependencyinjection.retrofit.BlogRetrofit
import com.example.hiltdependencyinjection.retrofit.NetworkMapper
import com.example.hiltdependencyinjection.room.BlogDao
import com.example.hiltdependencyinjection.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(blogDao, retrofit, cacheMapper, networkMapper)
    }
}