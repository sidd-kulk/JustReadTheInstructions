package com.sid.venkat.coroutines

fun intTask(){
    println("intTask Starts from ${Thread.currentThread()}")
    for(i in 1 .. 222) {
        val j = i * 44
    }
    println("intTask ends from ${Thread.currentThread()}")
}

fun stringTask(){
    println("stringTask Starts from ${Thread.currentThread()}")
    for(i in 1 .. 222) {
        val j = "$i abc"
    }
    println("stringTask ends from ${Thread.currentThread()}")
}

fun main() {
    nonCoroutine()
}

private fun nonCoroutine() {
    println("Start")
    run {
        intTask()
        stringTask()
        println("Done with run block from ${Thread.currentThread()}")
    }
    println("Stop")
}
