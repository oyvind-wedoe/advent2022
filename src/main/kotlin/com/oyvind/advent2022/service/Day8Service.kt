package com.oyvind.advent2022.service

import org.springframework.stereotype.Service

@Service
class Day8Service {

    fun a(input: String): Int {
        val map = createMap(input)

        var score = 0
        val maxXIndex = map.size - 1
        val maxYIndex = map[0].size - 1

        map.forEachIndexed { xIndex, line ->
            line.forEachIndexed { yIndex, number ->
                score += checkVisibilityContext(number, xIndex, yIndex, map, maxXIndex, maxYIndex)
            }
        }

        return score
    }

    private fun checkVisibilityContext(
        number: Int,
        xIndex: Int,
        yIndex: Int,
        map: MutableList<MutableList<Int>>,
        maxXIndex: Int,
        maxYIndex: Int
    ): Int {
        return if (checkVisibilityWest(number, xIndex, yIndex, map)) {
            1
        } else if (checkVisibilityNorth(number, xIndex, yIndex, map)) {
            1
        } else if (checkVisibilityEast(number, xIndex, yIndex, map, maxXIndex)) {
            1
        } else if (checkVisibilitySouth(number, xIndex, yIndex, map, maxYIndex)) {
            1
        } else 0
    }

    private fun checkVisibilitySouth(
        number: Int,
        xIndex: Int,
        yIndex: Int,
        map: MutableList<MutableList<Int>>,
        maxYIndex: Int
    ): Boolean {
        if (yIndex == maxYIndex) {
            return true
        }
        for (currentIndex in yIndex + 1..maxYIndex) {
            if (map[xIndex][currentIndex] >= number) {
                return false
            }
        }
        return true
    }

    private fun checkVisibilityEast(
        number: Int,
        xIndex: Int,
        yIndex: Int,
        map: MutableList<MutableList<Int>>,
        maxXIndex: Int,
    ): Boolean {
        if (xIndex == maxXIndex) {
            return true
        }
        for (currentIndex in xIndex + 1..maxXIndex) {
            if (map[currentIndex][yIndex] >= number) {
                return false
            }
        }
        return true
    }

    private fun checkVisibilityNorth(
        number: Int,
        xIndex: Int,
        yIndex: Int,
        map: MutableList<MutableList<Int>>
    ): Boolean {
        if (yIndex == 0) {
            return true
        }
        for (currentIndex in yIndex - 1 downTo (0)) {
            if (map[xIndex][currentIndex] >= number) {
                return false
            }
        }
        return true
    }

    private fun checkVisibilityWest(
        number: Int,
        xIndex: Int,
        yIndex: Int,
        map: MutableList<MutableList<Int>>
    ): Boolean {
        if (xIndex == 0) {
            return true
        }
        for (currentIndex in xIndex - 1 downTo (0)) {
            if (map[currentIndex][yIndex] >= number) {
                return false
            }
        }
        return true
    }

    fun b(input: String): Int {
        val map = createMap(input)

        var score = 0
        val maxXIndex = map.size - 1
        val maxYIndex = map[0].size - 1

        map.forEachIndexed { xIndex, line ->
            line.forEachIndexed { yIndex, _ ->
                val contender = checkScenicContext(xIndex, yIndex, map, maxXIndex, maxYIndex)
                score = maxOf(score, contender)
            }
        }

        return score
    }

    private fun createMap(input: String): MutableList<MutableList<Int>> {
        val map = mutableListOf<MutableList<Int>>()
        val firstInputLine = input.lines().first()

        firstInputLine.toCharArray().map { value ->
            map.add(mutableListOf(value.digitToInt()))
        }

        val restInput = input.lines().drop(1)

        restInput.map {
            it.trim().toCharArray().forEachIndexed { innerIndex, charValue ->
                map[innerIndex].add(charValue.digitToInt())
            }
        }

        return map
    }

    private fun checkScenicContext(
        xIndex: Int,
        yIndex: Int,
        map: MutableList<MutableList<Int>>,
        maxXIndex: Int,
        maxYIndex: Int
    ): Int {
        if (xIndex == 0 || yIndex == 0) {
            return 0
        }
        if (xIndex == maxXIndex || yIndex == maxYIndex) {
            return 0
        }

        val number = map[xIndex][yIndex]

        val checkScenicWest = checkScenicWest(number, xIndex, yIndex, map)
        val checkScenicNorth = checkScenicNorth(number, xIndex, yIndex, map)
        val checkScenicEast = checkScenicEast(number, xIndex, yIndex, map, maxXIndex)
        val checkScenicSouth = checkScenicSouth(number, xIndex, yIndex, map, maxYIndex)
        return checkScenicWest *
                checkScenicNorth *
                checkScenicEast *
                checkScenicSouth
    }

    private fun checkScenicWest(number: Int, xIndex: Int, yIndex: Int, map: MutableList<MutableList<Int>>): Int {
        var tallestVisible = 0
        var score = 0

        for (currentIndex in xIndex - 1 downTo (0)) {
            if (currentIndex == 0) {
                score = kotlin.math.abs(currentIndex - xIndex)
                break
            }
            val contender = map[currentIndex][yIndex]
            if (contender >= tallestVisible) {
                tallestVisible = contender
                score = kotlin.math.abs(currentIndex - xIndex)
                if (tallestVisible >= number) break
            }
        }

        return score
    }

    private fun checkScenicNorth(number: Int, xIndex: Int, yIndex: Int, map: MutableList<MutableList<Int>>): Int {
        var tallestVisible = 0
        var score = 0

        for (currentIndex in yIndex - 1 downTo (0)) {
            if (currentIndex == 0) {
                score = kotlin.math.abs(currentIndex - yIndex)
                break
            }
            val contender = map[xIndex][currentIndex]
            if (contender >= tallestVisible) {
                tallestVisible = contender
                score = kotlin.math.abs(currentIndex - yIndex)
                if (tallestVisible >= number) break
            }
        }
        return score
    }

    private fun checkScenicSouth(
        number: Int,
        xIndex: Int,
        yIndex: Int,
        map: MutableList<MutableList<Int>>,
        maxYIndex: Int
    ): Int {
        var tallestVisible = 0
        var score = 0

        for (currentIndex in yIndex + 1..maxYIndex) {
            if (currentIndex == maxYIndex) {
                score = kotlin.math.abs(currentIndex - yIndex)
                break
            }
            val contender = map[xIndex][currentIndex]
            if (contender >= tallestVisible) {
                tallestVisible = contender
                score = kotlin.math.abs(currentIndex - yIndex)
                if (tallestVisible >= number) break
            }
        }
        return score
    }

    private fun checkScenicEast(
        number: Int,
        xIndex: Int,
        yIndex: Int,
        map: MutableList<MutableList<Int>>,
        maxXIndex: Int
    ): Int {
        var tallestVisible = 0
        var score = 0

        for (currentIndex in xIndex + 1..maxXIndex) {
            if (currentIndex == maxXIndex) {
                score = kotlin.math.abs(currentIndex - xIndex)
                break
            }
            val contender = map[currentIndex][yIndex]
            if (contender >= tallestVisible) {
                tallestVisible = contender
                score = kotlin.math.abs(currentIndex - xIndex)
                if (tallestVisible >= number) break
            }
        }
        return score
    }
}