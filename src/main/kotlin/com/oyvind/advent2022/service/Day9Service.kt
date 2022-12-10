package com.oyvind.advent2022.service

import org.springframework.stereotype.Service

@Service
class Day9Service {

    fun a(input: String): Int {
        val currentPositions = Array(size = 2) {Position(0, 0)}
        val outcome = calculateSingleOutcome(currentPositions, Directions.D, 0, input.lines(), emptySet())

        return outcome.size
    }

    fun b(input: String): Int {
        val currentPositions = Array(size = 10) { Position(0, 0) }
        val outcome = calculateSingleOutcome(currentPositions, Directions.D, 0, input.lines(), emptySet())
        return outcome.size
    }

    private tailrec fun calculateSingleOutcome(
        currentPositions: Array<Position>,
        direction: Directions,
        repeat: Int,
        instructionLines: List<String>,
        currentOutput: Set<Any>
    ): Set<Any> {
        if (repeat == 0) {
            if (instructionLines.isEmpty()) {
                return currentOutput
            }
            val currentInstruction = instructionLines.first().split(" ")

            val newDirection = Directions.valueOf(currentInstruction.first())
            val numberOfOperations = currentInstruction.last().toInt()
            return calculateSingleOutcome(
                currentPositions,
                newDirection,
                numberOfOperations,
                instructionLines.drop(1),
                currentOutput
            )
        } else {
            val newPositions = getNewPositions(currentPositions, direction)
            return calculateSingleOutcome(
                newPositions,
                direction,
                repeat - 1,
                instructionLines,
                currentOutput + newPositions.last().copy(lastDirection = Directions.C)
            )
        }
    }

    private fun getNewPositions(currentPositions: Array<Position>, direction: Directions): Array<Position> {
        val currentRelations = currentPositions.dropLast(1).mapIndexed { index, position ->
            position.getRelationToOther(currentPositions[index + 1])
        }

        currentPositions[0].move(direction)

        for (index in 1 until currentPositions.size) {
            currentPositions[index].getNewPosition(currentRelations[index - 1], currentPositions[index - 1].lastDirection)
        }

        return currentPositions
    }

    enum class Directions {
        U,
        UR,
        R,
        DR,
        D,
        DL,
        L,
        UL,
        C
    }

    enum class RelationFromParentToChild {
        N,
        NE,
        E,
        SE,
        S,
        SW,
        W,
        NW,
        C
    }

    data class Position(
        var x: Int,
        var y: Int,
        var lastDirection: Directions = Directions.C,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Position

            if (x != other.x) return false
            if (y != other.y) return false

            return true
        }

        fun getRelationToOther(other: Position): RelationFromParentToChild {
            return if (x > other.x) {
                if (y > other.y) {
                    RelationFromParentToChild.NE
                } else if (y == other.y) {
                    RelationFromParentToChild.E
                } else {
                    RelationFromParentToChild.SE
                }
            } else if (x == other.x) {
                if (y > other.y) {
                    RelationFromParentToChild.N
                } else if (y == other.y) {
                    RelationFromParentToChild.C
                } else {
                    RelationFromParentToChild.S
                }
            } else {
                if (y > other.y) {
                    RelationFromParentToChild.NW
                } else if (y == other.y) {
                    RelationFromParentToChild.W
                } else {
                    RelationFromParentToChild.SW
                }
            }
        }

        fun move(direction: Directions) {
            when (direction) {
                Directions.U -> y++
                Directions.R -> x++
                Directions.D -> y--
                Directions.L -> x--
                Directions.UR -> {
                    y++
                    x++
                }
                Directions.DR -> {
                    y--
                    x++
                }
                Directions.DL -> {
                    y--
                    x--
                }
                Directions.UL -> {
                    y++
                    x--
                }
                else -> null
            }
            lastDirection = direction
        }
    }

    private fun Position.getNewPosition(
        originalRelationFromParentToChild: RelationFromParentToChild,
        parentMovementDirection: Directions
    ){
        if (originalRelationFromParentToChild == RelationFromParentToChild.C) {

        } else if (relationAndDirectionMatches(originalRelationFromParentToChild, parentMovementDirection)) {
                move(parentMovementDirection)
        } else {
            when (originalRelationFromParentToChild) {
                RelationFromParentToChild.NE -> {
                    when (parentMovementDirection) {
                        Directions.U, Directions.R -> {
                            move(Directions.UR)
                        }
                        Directions.DR -> {
                            move(Directions.R)
                        }
                        Directions.UL -> {
                            move(Directions.U)
                        }
                        else -> move(Directions.C)
                    }
                }

                RelationFromParentToChild.SE -> {
                    when (parentMovementDirection) {
                        Directions.R, Directions.D-> {
                            move(Directions.DR)
                        }
                        Directions.UR -> {
                            move(Directions.R)
                        }
                        Directions.DL -> {
                            move(Directions.D)
                        }
                        else -> move(Directions.C)
                    }
                }

                RelationFromParentToChild.SW -> {
                    when (parentMovementDirection) {
                        Directions.D, Directions.L -> {
                            move(Directions.DL)
                        }
                        Directions.DR -> {
                            move(Directions.D)
                        }
                        Directions.UL -> {
                            move(Directions.L)

                        }
                        else -> move(Directions.C)
                    }
                }

                RelationFromParentToChild.NW -> {
                    when (parentMovementDirection) {
                        Directions.U, Directions.L -> {
                            move(Directions.UL)
                        }
                        Directions.UR -> {
                            move(Directions.U)
                        }
                        Directions.DL -> {
                            move(Directions.L)
                        }
                        else -> move(Directions.C)
                    }
                }

                RelationFromParentToChild.N -> {
                    when (parentMovementDirection) {
                        Directions.UR -> {
                            move(Directions.UR)
                        }
                        Directions.UL -> {
                            move(Directions.UL)
                        }
                        else -> move(Directions.C)
                    }
                }
                RelationFromParentToChild.E -> {
                    when (parentMovementDirection) {
                        Directions.UR -> {
                            move(Directions.UR)
                        }
                        Directions.DR -> {
                            move(Directions.DR)
                        }
                        else -> move(Directions.C)
                    }
                }
                RelationFromParentToChild.S -> {
                    when (parentMovementDirection) {
                        Directions.DR -> {
                            move(Directions.DR)
                        }
                        Directions.DL -> {
                            move(Directions.DL)
                        }
                        else -> move(Directions.C)
                    }
                }
                RelationFromParentToChild.W -> {
                    when(parentMovementDirection) {
                        Directions.DL -> {
                            move(Directions.DL)
                        }
                        Directions.UL -> {
                            move(Directions.UL)
                        }
                        else -> move(Directions.C)
                    }
                }
                else -> error("error in newPosition")
            }
        }
    }

    private fun relationAndDirectionMatches(
        relationFromParentToChild: RelationFromParentToChild,
        direction: Directions
    ): Boolean {
        return (relationFromParentToChild == RelationFromParentToChild.N && direction == Directions.U) ||
                (relationFromParentToChild == RelationFromParentToChild.NE && direction == Directions.UR) ||
                (relationFromParentToChild == RelationFromParentToChild.E && direction == Directions.R) ||
                (relationFromParentToChild == RelationFromParentToChild.SE && direction == Directions.DR) ||
                (relationFromParentToChild == RelationFromParentToChild.S && direction == Directions.D) ||
                (relationFromParentToChild == RelationFromParentToChild.SW && direction == Directions.DL) ||
                (relationFromParentToChild == RelationFromParentToChild.W && direction == Directions.L) ||
                (relationFromParentToChild == RelationFromParentToChild.NW && direction == Directions.UL)
    }
}