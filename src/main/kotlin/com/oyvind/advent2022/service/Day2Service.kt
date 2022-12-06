package com.oyvind.advent2022.service

import org.springframework.stereotype.Service

@Service
class Day2Service {

    enum class option {
        ROCK,
        PAPER,
        SCISSORS
    }

    enum class outcome {
        WIN,
        LOSE,
        DRAW
    }

    val firstToOption = mapOf(
        "A" to option.ROCK,
        "B" to option.PAPER,
        "C" to option.SCISSORS
    )

    val secondToOption = mapOf(
        "X" to option.ROCK,
        "Y" to option.PAPER,
        "Z" to option.SCISSORS
    )

    val secondToOutcome = mapOf(
        "X" to outcome.LOSE,
        "Y" to outcome.DRAW,
        "Z" to outcome.WIN
    )

    val optionToScore = mapOf(
        option.ROCK to 1,
        option.PAPER to 2,
        option.SCISSORS to 3
    )

    val outcomeToScore = mapOf(
        outcome.WIN to 6,
        outcome.LOSE to 0,
        outcome.DRAW to 3
    )

    val optionAndOptionToOutcome = mapOf(
        option.ROCK to mapOf(
            option.ROCK to outcome.DRAW,
            option.PAPER to outcome.LOSE,
            option.SCISSORS to outcome.WIN
        ),
        option.PAPER to mapOf(
            option.ROCK to outcome.WIN,
            option.PAPER to outcome.DRAW,
            option.SCISSORS to outcome.LOSE
        ),
        option.SCISSORS to mapOf(
            option.ROCK to outcome.LOSE,
            option.PAPER to outcome.WIN,
            option.SCISSORS to outcome.DRAW
        )
    )

    val outcomeAndOpponentOptionToMyOption = mapOf(
        outcome.WIN to mapOf(
            option.ROCK to option.PAPER,
            option.PAPER to option.SCISSORS,
            option.SCISSORS to option.ROCK
        ),
        outcome.LOSE to mapOf(
            option.ROCK to option.SCISSORS,
            option.PAPER to option.ROCK,
            option.SCISSORS to option.PAPER
        ),
        outcome.DRAW to mapOf(
            option.ROCK to option.ROCK,
            option.PAPER to option.PAPER,
            option.SCISSORS to option.SCISSORS
        )
    )

    fun myOptionAndOpponentOptionToScore(me: String, opponent: String): Int {
        val myOption = secondToOption[me]
        val opponentOption = firstToOption[opponent]
        val outcome = optionAndOptionToOutcome[myOption]!![opponentOption]!!
        val outcomeScore = outcomeToScore[outcome]!!
        val optionScore = optionToScore[myOption]!!
        return outcomeScore + optionScore
    }

    fun myOutcomeAndOpponentOptionToScore(me: String, opponent: String): Int {
        val outcome = secondToOutcome[me]
        val opponentOption = firstToOption[opponent]
        val myOption = outcomeAndOpponentOptionToMyOption[outcome]!![opponentOption]!!
        val outcomeScore = outcomeToScore[outcome]!!
        val optionScore = optionToScore[myOption]!!
        return outcomeScore + optionScore
    }

    fun a(input: List<String>): Int {
        return input.map { line ->
                val (opponent, me) = line.split(" ")
                myOptionAndOpponentOptionToScore(me = me, opponent = opponent)
            }.sum()
    }

    fun b(input: List<String>): Int {
        return input.map { line ->
            val (opponent, me) = line.split(" ")
            myOutcomeAndOpponentOptionToScore(me = me, opponent = opponent)
        }.sum()
    }
}