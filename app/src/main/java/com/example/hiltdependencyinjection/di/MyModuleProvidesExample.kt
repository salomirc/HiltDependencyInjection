package com.example.hiltdependencyinjection.di

import com.example.hiltdependencyinjection.SomeInterfaceTwo
import com.example.hiltdependencyinjection.SomeInterfaceTwoImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MyModuleProvidesExample {

    @Singleton
    @Provides
    fun provideSomeInterfaceTwo(gson: Gson): SomeInterfaceTwo {
        return SomeInterfaceTwoImpl(gson)
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
}