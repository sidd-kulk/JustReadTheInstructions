package com.sid.skienna.datastructures

import java.lang.IndexOutOfBoundsException

interface Collection<T> {
    var data: MutableList<T>

    fun genericAdd(element: T): Collection<T> {
        data.add(element)
        return this
    }

    fun genericRemoveFirst(): T {
        if (data.size == 0) throw IndexOutOfBoundsException("Cannot pop from an empty collection")
        return data.removeAt(0)
    }

     fun string(): String {
        return data.toString()
    }
}

class Queue<T> : Collection<T> {
    override var data = mutableListOf<T>()

    fun enqueue(element: T): Queue<T> {
        super.genericAdd(element)
        return this
    }

    fun dequeue(): T {
        return genericRemoveFirst()
    }

    override fun toString(): String {
        return string()
    }
}

class Stack<T> : Collection<T> {
    override var data = mutableListOf<T>()

    fun push(element: T): Stack<T> {
        super.genericAdd(element)
        return this
    }

    fun pop(): T {
        return genericRemoveFirst()
    }

    override fun toString(): String {
        return string()
    }
}