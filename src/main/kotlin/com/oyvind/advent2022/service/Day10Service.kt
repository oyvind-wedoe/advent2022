package com.oyvind.advent2022.service

import org.springframework.stereotype.Service

@Service
class Day10Service {

    fun a(input: String): Int {
        val xRegister = 1
        val currentCycle = 0
        val instructionLines = input.lines()
        val remainingCyclesInCurrentInstruction = 0
        val totalSignalStrength = 0
        return handleInstruction(
            xRegister,
            currentCycle,
            instructionLines,
            remainingCyclesInCurrentInstruction,
            totalSignalStrength,
        )
    }

    val relevantCycles = listOf(
        20,
        60,
        100,
        140,
        180,
        220
    )

    enum class Instruction {
        addx,
        noop
    }

    private tailrec fun handleInstruction(
        xRegister: Int,
        currentCycle: Int,
        instructionLines: List<String>,
        remainingCyclesInCurrentInstruction: Int,
        totalSignalStrength: Int,
        currentInstruction: Instruction? = null,
        currentRegisterChange: Int = 0,
        graphicOutput: String = "",
        solveForB: Boolean = false
    ): Int {
        var graphicChange = ""
        if (currentCycle > 0 && solveForB) {
            graphicChange = if (xRegister in getPixelVicinity(graphicOutput.length.mod(40))){
                "#"
            } else
                "."
        }
        if (instructionLines.isEmpty()){
            println("hei")
        }


        var totalSignalStrengthChange = 0
        if (!solveForB && currentCycle in relevantCycles) {
            totalSignalStrengthChange = currentCycle * xRegister
            if (currentCycle == relevantCycles.last()) {
                return totalSignalStrength + totalSignalStrengthChange
            }
        }

        if (remainingCyclesInCurrentInstruction == 0) {
            val nextInstructionLine = instructionLines.first().split(" ")
            if (nextInstructionLine.first().isNullOrEmpty()) {
                val output = graphicOutput.chunked(40)

                output.forEach {
                    println(it)
                }
                return 0
            }

            when(val nextInstruction = Instruction.valueOf(nextInstructionLine.first())) {
                Instruction.addx -> {
                    return handleInstruction(
                        xRegister = xRegister + currentRegisterChange,
                        currentCycle = currentCycle + 1,
                        instructionLines = instructionLines.drop(1),
                        remainingCyclesInCurrentInstruction = 1,
                        totalSignalStrength = totalSignalStrength + totalSignalStrengthChange,
                        currentInstruction = nextInstruction,
                        currentRegisterChange = nextInstructionLine.last().toInt(),
                        graphicOutput = graphicOutput + graphicChange,
                        solveForB = solveForB,
                    )
                }
                Instruction.noop -> return handleInstruction(
                    xRegister = xRegister + currentRegisterChange,
                    currentCycle = currentCycle + 1,
                    instructionLines = instructionLines.drop(1),
                    remainingCyclesInCurrentInstruction = 0,
                    totalSignalStrength = totalSignalStrength + totalSignalStrengthChange,
                    currentInstruction = null,
                    currentRegisterChange = 0,
                    graphicOutput = graphicOutput + graphicChange,
                    solveForB = solveForB,
                )
            }
        } else {
            return handleInstruction(
                xRegister = xRegister,
                currentCycle = currentCycle + 1,
                instructionLines = instructionLines,
                remainingCyclesInCurrentInstruction = 0,
                totalSignalStrength = totalSignalStrength + totalSignalStrengthChange,
                currentInstruction = currentInstruction,
                currentRegisterChange = currentRegisterChange,
                graphicOutput = graphicOutput + graphicChange,
                solveForB = solveForB,
            )
        }
    }

    fun b(input: String): Int {
        val xRegister = 1
        val currentCycle = 0
        val instructionLines = input.lines()
        val remainingCyclesInCurrentInstruction = 0
        val totalSignalStrength = 0
        var output = ""
        return handleInstruction(
            xRegister = xRegister,
            currentCycle = currentCycle,
            instructionLines = instructionLines,
            remainingCyclesInCurrentInstruction = remainingCyclesInCurrentInstruction,
            totalSignalStrength = totalSignalStrength,
            currentInstruction = null,
            currentRegisterChange = 0,
            graphicOutput = output,
            solveForB = true,
        )
    }
    fun getPixelVicinity(position: Int): List<Int> {
        return listOf(position - 1, position, position + 1)
    }
}




