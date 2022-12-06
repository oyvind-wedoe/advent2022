package com.oyvind.advent2022.service

import org.springframework.stereotype.Service

@Service
class Day4Service {

    fun a(input: List<String>, solveForB: Boolean = false): Int {
        return input.sumOf {
            val split = it.split(",")
            val firstGroup = split.first()
            val firstSplit = firstGroup.split("-")
            val firstStart = firstSplit.first().toInt()
            val firstEnd = firstSplit.last().toInt()
            val firstArray = IntArray(size = firstEnd + 1 - firstStart) { i -> i + firstStart}

            val secondGroup = split.last()
            val secondSplit = secondGroup.split("-")
            val secondStart = secondSplit.first().toInt()
            val secondEnd = secondSplit.last().toInt()

            val secondArray = IntArray(size = secondEnd + 1 - secondStart) { i -> i + secondStart}

            if (solveForB && firstArray.intersect(secondArray.toSet()).isNotEmpty()) {
                1.toInt()
            } else if (firstArray.intersect(secondArray.toSet()).size == minOf(firstArray.size, secondArray.size)) {
                1.toInt()
            } else 0
        }
    }

    fun b(input: List<String>): Int {
        return a(input, true)
    }
}