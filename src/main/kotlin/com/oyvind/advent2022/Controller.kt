package com.oyvind.advent2022

import com.oyvind.advent2022.service.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
class Controller(
    private val day1Service: Day1Service,
    private val day2Service: Day2Service,
    private val day3Service: Day3Service,
    private val day4Service: Day4Service,
    private val day5Service: Day5Service,
    private val day6Service: Day6Service,
    private val day7Service: Day7Service,
    private val day8Service: Day8Service,
    private val day9Service: Day9Service,
) {


    val input1 = File("src/main/resources/input/input1.txt").readLines()
    val input2 = File("src/main/resources/input/input2.txt").readLines()
    val input3 = File("src/main/resources/input/input3.txt").readLines()
    val input4 = File("src/main/resources/input/input4.txt").readLines()
    val input5 = File("src/main/resources/input/input5.txt").readText()
    val input6 = File("src/main/resources/input/input6.txt").readText()
    val input7 = File("src/main/resources/input/input7.txt").readText()
    val input8 = File("src/main/resources/input/input8.txt").readText()
    val input9 = File("src/main/resources/input/input9.txt").readText()

    @GetMapping("/day1a")
    fun day1a(): Int {
        return day1Service.a(input1)
    }

    @GetMapping("/day1b")
    fun day1b(): Int {
        return day1Service.b(input1)
    }

    @GetMapping("/day2a")
    fun day2a(): Int {
        return day2Service.a(input2)
    }

    @GetMapping("/day2b")
    fun day2b(): Int {
        return day2Service.b(input2)
    }

    @GetMapping("/day3a")
    fun day3a(): Int {
        return day3Service.a(input3)
    }

    @GetMapping("/day3b")
    fun day3b(): Int {
        return day3Service.b(input3)
    }

    @GetMapping("/day4a")
    fun day4a(): Int {
        return day4Service.a(input4)
    }

    @GetMapping("/day4b")
    fun day4b(): Int {
        return day4Service.b(input4)
    }

    @GetMapping("/day5a")
    fun day5a(): String {
        return day5Service.a(input5)
    }

    @GetMapping("/day5b")
    fun day5b(): String {
        return day5Service.b(input5)
    }

    @GetMapping("/day6a")
    fun day6a(): Int {
        return day6Service.a(input6)
    }

    @GetMapping("/day6b")
    fun day6b(): Int {
        return day6Service.b(input6)
    }

    @GetMapping("/day7a")
    fun day7a(): Int {
        return day7Service.a(input7)
    }

    @GetMapping("/day7b")
    fun day7b(): Int {
        return day7Service.b(input7)
    }

    @GetMapping("/day8a")
    fun day8a(): Int {
        return day8Service.a(input8)
    }

    @GetMapping("/day8b")
    fun day8b(): Int {
        return day8Service.b(input8)
    }

    @GetMapping("/day9a")
    fun day9a(): Int {
        return day9Service.a(input9)
    }

    @GetMapping("/day9b")
    fun day9b(): Int {
        return day9Service.b(input9)
    }
}