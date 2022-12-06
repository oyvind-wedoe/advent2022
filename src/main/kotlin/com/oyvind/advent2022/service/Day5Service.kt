package com.oyvind.advent2022.service

import org.springframework.stereotype.Service

@Service
class Day5Service {

    fun a(input: String, solveForB: Boolean = false): String {
        val splitInput = input.split("\n\n")
        val startGroup = splitInput.first().lines()
        val instructionGroup = splitInput.last().lines()

        val numberOfColumns = startGroup.last().split("  ").last().trim().toInt()
        val maxHeight = startGroup.size - 1
        val startInput = startGroup.take(maxHeight).reversed()

        val lines = startInput.map {
            it.chunked(4).map { member -> member.substring(1, 2).trim() }
        }

        val crates = List(numberOfColumns) { "" }.toMutableList()

        lines.forEach { line ->
            line.forEachIndexed { innerIndex, member ->
                crates[innerIndex] += member
            }
        }

        val result = handleInstructions(crates, instructionGroup, solveForB)

        return getOutput(result)
    }

    private fun handleInstructions(
        crates: MutableList<String>,
        instructionGroup: List<String>,
        solveForB: Boolean
    ): List<String> {
        instructionGroup.forEach {
            if (it.isNotEmpty()) {
                handleInstruction(crates, it, solveForB)
            }
        }

        return crates
    }

    private fun handleInstruction(
        currentCrates: MutableList<String>,
        instruction: String,
        solveForB: Boolean
    ): MutableList<String> {
        val instructionGroup = instruction.split(" ")
        val numberToMove = instructionGroup[1].toInt()
        val originColumn = instructionGroup[3].toInt()
        val targetColumn = instructionGroup[5].toInt()

        val sectionToMove =
            currentCrates[originColumn - 1].substring(currentCrates[originColumn - 1].length - numberToMove)

        if (solveForB) {
            currentCrates[targetColumn - 1] += sectionToMove
        } else {
            currentCrates[targetColumn - 1] += sectionToMove.reversed()
        }

        currentCrates[originColumn - 1] = currentCrates[originColumn - 1].dropLast(numberToMove)

        return currentCrates
    }


    private fun getOutput(crates: List<String>): String {
        return crates.map {
            it.lastOrNull() ?: ""
        }.joinToString(separator = "")

    }

    fun b(input: String): String {
        return a(input = input, solveForB = true)
    }

}