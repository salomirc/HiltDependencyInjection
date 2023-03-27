package com.example.hiltdependencyinjection.di

import com.example.hiltdependencyinjection.SomeInterfaceOne
import com.example.hiltdependencyinjection.SomeInterfaceOneImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class MyModuleBindExample {

    // Specifying a scope is optional
    //@ActivityScoped
    @Binds
    abstract fun bindSomeDependency(
        someIml: SomeInterfaceOneImpl
    ): SomeInterfaceOne


}

//@Module
//@InstallIn(SingletonComponent::class)
//abstract class MyModule {
//
//    @Singleton
//    @Binds
//    abstract fun bindSomeDependency(
//        someIml: SomeInterfaceImpl
//    ): SomeInterface
//}