package com.sid.robertsedgewick.search.symboltables

import java.io.File

class FileHandler(val file: File) {
    fun parseFile() {

    }

    fun streamFile() {

    }
}

class FrequencyCounter(val text: String) {
    private val wordFrequencies = mutableMapOf<String, Int>()
    private var isAnalysed = false

    fun analyse(): Map<String, Int> {
        val tokens = text.split("\\s+".toRegex())
        tokens.forEach {
            val currentCount = wordFrequencies[it]
            when {
                currentCount != null -> {
                    wordFrequencies[it] = currentCount + 1
                }
                else -> {
                    wordFrequencies[it] = 1
                }
            }
        }
        isAnalysed = true

        return wordFrequencies.toList().sortedByDescending { (_, value) -> value}.toMap()
    }

    fun getFrequencyFor(word: String): Int {
        if(!isAnalysed) {
            throw IllegalStateException("Text Analysis pending, please invoke analysis before getting frequencies")
        }
        return wordFrequencies.getOrDefault(word, 0)
    }
}

fun main() {
    val fileContents = File("/Users/siddharth/Desktop/decisoins.txt").readText()
    println(FrequencyCounter(fileContents).analyse())
}