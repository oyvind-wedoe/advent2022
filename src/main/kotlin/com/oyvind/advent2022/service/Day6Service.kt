package com.oyvind.advent2022.service

import org.springframework.stereotype.Service

@Service
class Day6Service {

    fun a(input: String, solveForB: Boolean = false): Int {
        val inputAsArray = input.toCharArray()
        var marker = 0
        var segmentLength = 4
        if (solveForB) {
            segmentLength = 14
        }

        repeat(inputAsArray.size - 3) {index ->
            val currentList = emptyList<Char>().toMutableList()
            repeat(segmentLength) {segmentIndex ->
                currentList += inputAsArray[index + segmentIndex]
            }

            if (currentList.distinct().size == currentList.size) {
                return marker + segmentLength
            }
            marker++
        }
        return 0
    }

    fun b(input: String): Int {
        return a(input = input, solveForB = true)
    }
}