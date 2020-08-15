package com.sid.robertsedgewick.search.symboltables

interface SymbolTable <K , V> where K: Comparable<K> {

    fun put(key: K, value: V)

    fun get(key: K): V?

    fun contains(key: K): Boolean {
        return get(key) != null
    }

    fun delete(key: K): V?

    fun size(): Int

    fun isEmpty(): Boolean

    fun keys(): Iterable<K>

    fun values(): Iterable<V>
}