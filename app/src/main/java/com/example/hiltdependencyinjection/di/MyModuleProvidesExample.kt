package com.example.hiltdependencyinjection.di

import com.example.hiltdependencyinjection.dependencies.*
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
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

    @Impl1
    @Singleton
    @Provides
    fun provideSomeInterfaceThree1(): SomeInterfaceThree {
        return SomeInterfaceThreeImplOne()
    }

    @Impl2
    @Singleton
    @Provides
    fun provideSomeInterfaceThree2(): SomeInterfaceThree {
        return SomeInterfaceThreeImplTwo()
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl2