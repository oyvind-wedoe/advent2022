package com.oyvind.advent2022.service

import org.springframework.stereotype.Service

@Service
class Day3Service {

    val letterToScore = mapOf(
        "a" to 1,
        "b" to 2,
        "c" to 3,
        "d" to 4,
        "e" to 5,
        "f" to 6,
        "g" to 7,
        "h" to 8,
        "i" to 9,
        "j" to 10,
        "k" to 11,
        "l" to 12,
        "m" to 13,
        "n" to 14,
        "o" to 15,
        "p" to 16,
        "q" to 17,
        "r" to 18,
        "s" to 19,
        "t" to 20,
        "u" to 21,
        "v" to 22,
        "w" to 23,
        "x" to 24,
        "y" to 25,
        "z" to 26,
        "A" to 27,
        "B" to 28,
        "C" to 29,
        "D" to 30,
        "E" to 31,
        "F" to 32,
        "G" to 33,
        "H" to 34,
        "I" to 35,
        "J" to 36,
        "K" to 37,
        "L" to 38,
        "M" to 39,
        "N" to 40,
        "O" to 41,
        "P" to 42,
        "Q" to 43,
        "R" to 44,
        "S" to 45,
        "T" to 46,
        "U" to 47,
        "V" to 48,
        "W" to 49,
        "X" to 50,
        "Y" to 51,
        "Z" to 52,
    )


    fun a(input: List<String>): Int {
        return input.sumOf {
            val halfway = it.length / 2
            val firstPart = it.substring(0, halfway).toCharArray()
            val secondPart = it.substring(halfway).toCharArray()

            val duplicate = firstPart.intersect(secondPart.toSet()).first()
            letterToScore[duplicate.toString()] ?: 0
        }
    }

    fun b(input: List<String>): Int {
        val numberOfGroups = input.size / 3
        var sum = 0
        var current = 0
        repeat(numberOfGroups) {
            sum += getBadgeScore(
                input[current++].toCharArray(),
                input[current++].toCharArray(),
                input[current++].toCharArray()
            )
        }

        return sum
    }

    private fun getBadgeScore(first: CharArray, second: CharArray, third: CharArray): Int {
        return letterToScore[first.intersect(second.toSet()).intersect(third.toSet()).first().toString()] ?: 0
    }
}