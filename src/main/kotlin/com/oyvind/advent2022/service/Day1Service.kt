package com.oyvind.advent2022.service

import org.springframework.stereotype.Service
import kotlin.math.max

@Service
class Day1Service {

    var first = 0
    var second = 0
    var third = 0
    var current = 0


    fun a(input: List<String>): Int {
        var largest = 0
        for (s in input) {
            if (s.isEmpty()) {
                largest = max(largest, current)
                current = 0
            } else {
                current += s.toInt()
            }
        }
        return current
    }

    fun b(input: List<String>): Int {
        for (s in input) {
            if (s.isEmpty()) {
                handleTotal(current)
                current = 0
            } else {
                current += s.toInt()
            }
        }
        return first + second + third
    }

    private fun handleTotal(input: Int) {
        if (input > first) {
            third = second
            second = first
            first = input
        } else if (input > second) {
            third = second
            second = input
        } else if (input > third) {
            third = input
        }
    }
}