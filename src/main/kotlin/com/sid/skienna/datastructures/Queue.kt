package com.sid.skienna.datastructures

class Queue <T> (val defaultSize: Int = 16) {
    private var data = mutableListOf<T>()

    fun add(element: T) {
        data.add(element)
    }

    fun pop(): T {
        val r = data[0]
        data.removeAt(0)
        return r
    }

    fun peek(): T {
        return data[0]
    }

    fun size(): Int {
        return data.size
    }
}