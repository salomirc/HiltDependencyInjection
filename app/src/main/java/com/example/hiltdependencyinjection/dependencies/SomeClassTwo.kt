package com.example.hiltdependencyinjection.dependencies

import com.example.hiltdependencyinjection.di.Impl1
import com.example.hiltdependencyinjection.di.Impl2
import javax.inject.Inject

class SomeClassTwo @Inject constructor(
    @Impl1 private val someInterfaceThreeImplOne: SomeInterfaceThree,
    @Impl2 private val someInterfaceThreeImplTwo: SomeInterfaceThree,
){
    fun doAThing(): String{
        return "Look I got: ${someInterfaceThreeImplOne.getAThing()} and ${someInterfaceThreeImplTwo.getAThing()}"
    }
}

class SomeInterfaceThreeImplOne @Inject constructor(): SomeInterfaceThree {
    override fun getAThing() : String{
        return "A Thing Three from One"
    }
}

class SomeInterfaceThreeImplTwo @Inject constructor(): SomeInterfaceThree {
    override fun getAThing() : String{
        return "A Thing Three from Two"
    }
}

interface SomeInterfaceThree {
    fun getAThing(): String
}