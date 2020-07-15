package com.sid.skienna.datastructures

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class QueueTest {

    lateinit var queue: Queue<Int>

    @BeforeEach
    fun setUp(){
        queue = Queue<Int>().add(12).add(34)
    }

    @Test
    fun `should add to the queue and peek the element`() {
        assertThat(queue.peek()).isEqualTo(12)
        assertThat(queue.size()).isEqualTo(2)
    }

    @Test
    fun `should pop elements from the queue`() {
        assertThat(queue.pop()).isEqualTo(12)
        assertThat(queue.pop()).isEqualTo(34)
        assertThat(queue.size()).isEqualTo(0)
    }

    @Test
    fun `should give String representation of the queue`(){
        assertThat(queue.toString()).isEqualTo("[12, 34]")
    }
}