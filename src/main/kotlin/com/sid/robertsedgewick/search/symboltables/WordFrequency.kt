package com.sid.robertsedgewick.search.symboltables

import java.io.File
import kotlin.system.measureTimeMillis

val LARGE_FILE = "./large_file.txt"

class FrequencyCounter(private val text: String) {

    private val wordFrequencies = mutableMapOf<String, Int>()
    private var isAnalysed = false

    fun analyse(): Map<String, Int> {
        val tokens = text.toLowerCase().split("\\s+".toRegex())
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

        return wordFrequencies
    }
}

fun main() {
    processLargeFile()
}

fun processLargeFile() {
    val time = measureTimeMillis {
        buffered() // Works like a charm
        // inMemory()  // Throws OOM
    }

    println(time.toString().plus(" milliseconds"))
}

private fun inMemory() {
    val fileContents = File(LARGE_FILE).readText()
    val frequencyCounter = FrequencyCounter(fileContents)
    val frequencyMap = frequencyCounter.analyse()
}

private fun buffered() {
    val inputStream = File(LARGE_FILE).inputStream()
    var frequencyMap = mutableMapOf<String, Int>()
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach {
            val frequencyCounter = FrequencyCounter(it)
            frequencyMap.putAll(frequencyCounter.analyse())
        }
    }
}
