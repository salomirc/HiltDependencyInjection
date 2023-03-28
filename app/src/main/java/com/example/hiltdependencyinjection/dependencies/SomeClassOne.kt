package com.example.hiltdependencyinjection.dependencies

import com.google.gson.Gson
import javax.inject.Inject

class SomeClassOne @Inject constructor(
    private val someInterfaceOneImpl: SomeInterfaceOne,
    private val someInterfaceTwoImpl: SomeInterfaceTwo
){
    fun doAThing(): String{
        return "Look I got: ${someInterfaceOneImpl.getAThing()} and ${someInterfaceTwoImpl.getAThing()}"
    }
}

class SomeInterfaceOneImpl @Inject constructor(): SomeInterfaceOne {
    override fun getAThing() : String{
        return "A Thing One"
    }
}

class SomeInterfaceTwoImpl @Inject constructor(private val gson: Gson): SomeInterfaceTwo {
    override fun getAThing() : String{
        return "A Thing Two + ${gson.hashCode()}"
    }
}

interface SomeInterfaceOne{
    fun getAThing(): String
}

interface SomeInterfaceTwo{
    fun getAThing(): String
}