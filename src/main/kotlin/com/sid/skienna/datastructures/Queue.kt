package com.sid.skienna.datastructures

class Queue <T> (private val defaultSize: Int = 16) {
    private var data = mutableListOf<T>()

    fun add(element: T) : Queue<T> {
        data.add(element)
        return this
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

    override fun toString(): String {
        return data.toString()
    }
}