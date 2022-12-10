package com.oyvind.advent2022

import com.oyvind.advent2022.service.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class Advent2022ApplicationTests {

    private val day2Service = Day2Service()
    private val day3Service = Day3Service()
    private val day4Service = Day4Service()
    private val day5Service = Day5Service()
    private val day6Service = Day6Service()
    private val day7Service = Day7Service()
    private val day8Service = Day8Service()
    private val day9Service = Day9Service()
    private val day10Service = Day10Service()
    private val day11Service = Day11Service()
    private val day12Service = Day12Service()
    private val day13Service = Day13Service()
    private val day14Service = Day14Service()
    private val day15Service = Day15Service()
    private val day16Service = Day16Service()
    private val day17Service = Day17Service()
    private val day18Service = Day18Service()
    private val day19Service = Day19Service()


    @Test
    fun contextLoads() {
    }

    @Test
    fun `day2a`() {
        val testInput = """
			A Y
			B X
			C Z
		""".trimIndent()

        assertEquals(day2Service.a(testInput.lines()), 15)
    }

    @Test
    fun `day2b`() {
        val testInput = """
			A Y
			B X
			C Z
		""".trimIndent()

        assertEquals(day2Service.b(testInput.lines()), 12)
    }

    @Test
    fun `day3a`() {
        val testInput = """
			vJrwpWtwJgWrhcsFMMfFFhFp
			jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
			PmmdzqPrVvPwwTWBwg
			wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
			ttgJtRGJQctTZtZT
			CrZsJsPPZsGzwwsLwLmpwMDw
		""".trimIndent()

        assertEquals(day3Service.a(testInput.lines()), 157)
    }

    @Test
    fun `day3b`() {
        val testInput = """
			vJrwpWtwJgWrhcsFMMfFFhFp
			jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
			PmmdzqPrVvPwwTWBwg
			wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
			ttgJtRGJQctTZtZT
			CrZsJsPPZsGzwwsLwLmpwMDw
		""".trimIndent()

        assertEquals(day3Service.b(testInput.lines()), 70)
    }

    @Test
    fun `day4a`() {
        val testInput = """
		2-4,6-8
		2-3,4-5
		5-7,7-9
		2-8,3-7
		6-6,4-6
		2-6,4-8
		""".trimIndent()

        assertEquals(day4Service.a(testInput.lines()), 2)
    }

    @Test
    fun `day4b`() {
        val testInput = """
		2-4,6-8
		2-3,4-5
		5-7,7-9
		2-8,3-7
		6-6,4-6
		2-6,4-8
		""".trimIndent()

        assertEquals(day4Service.b(testInput.lines()), 4)
    }

    @Test
    fun `day5a`() {
        val testInput = """
    [D]       
[N] [C]       
[Z] [M] [P]   
 1   2   3   4 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
		""".trimIndent()

        assertEquals("CMZ", day5Service.a(testInput))

    }

    @Test
    fun `day5b`() {
        val testInput = """
    [D]       
[N] [C]       
[Z] [M] [P]   
 1   2   3   4 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
		""".trimIndent()

        assertEquals("MCD", day5Service.b(testInput))

    }

    @Test
    fun `day6a`() {
        assertEquals(5, day6Service.a("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(6, day6Service.a("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(10, day6Service.a("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(11, day6Service.a("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }

    @Test
    fun `day6b`() {
        assertEquals(19, day6Service.b("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(23, day6Service.b("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(23, day6Service.b("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(29, day6Service.b("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(26, day6Service.b("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }

    @Test
    fun `day7a`() {
        val testInput = """
${'$'} cd /
${'$'} ls
dir a
14848514 b.txt
8504156 c.dat
dir d
${'$'} cd a
${'$'} ls
dir e
29116 f
2557 g
62596 h.lst
${'$'} cd e
${'$'} ls
584 i
${'$'} cd ..
${'$'} cd ..
${'$'} cd d
${'$'} ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k
		""".trimIndent()

        assertEquals(95437, day7Service.a(testInput))
    }

    @Test
    fun `day7b`() {
        val testInput = """
${'$'} cd /
${'$'} ls
dir a
14848514 b.txt
8504156 c.dat
dir d
${'$'} cd a
${'$'} ls
dir e
29116 f
2557 g
62596 h.lst
${'$'} cd e
${'$'} ls
584 i
${'$'} cd ..
${'$'} cd ..
${'$'} cd d
${'$'} ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k
		""".trimIndent()

        assertEquals(24933642, day7Service.b(testInput))
    }


    @Test
    fun `day8a`() {
        val testInput = """
        30373
        25512
        65332
        33549
        35390        
		""".trimIndent()

        assertEquals(21, day8Service.a(testInput))
    }

    @Test
    fun `day8b`() {
        val testInput = """
        30373
        25512
        65332
        33549
        35390
		""".trimIndent()

        assertEquals(8, day8Service.b(testInput))
    }

    @Test
    fun `day9a`() {
        val testInput = """
            R 4
            U 4
            L 3
            D 1
            R 4
            D 1
            L 5
            R 2
		""".trimIndent()

        assertEquals(13, day9Service.a(testInput))
    }

    @Test
    fun `day9aFull`() {
        assertEquals(6098, day9Service.a(File("src/main/resources/input/input9.txt").readText()))
    }

    @Test
    fun `day9bsimple`() {
        val testInput = """
            R 4
            U 4
            L 3
            D 1
            R 4
            D 1
            L 5
            R 2
		""".trimIndent()

        assertEquals(1, day9Service.b(testInput))
    }

    @Test
    fun `day9b`() {
        val testInput = """
            R 5
            U 8
            L 8
            D 3
            R 17
            D 10
            L 25
            U 20
		""".trimIndent()

        assertEquals(36, day9Service.b(testInput))
    }

    @Test
    fun `day9bFull`() {
        assertEquals(2597, day9Service.b(File("src/main/resources/input/input9.txt").readText()))
    }

    @Test
    fun `day10a`() {
        val testInput = """
            addx 15
            addx -11
            addx 6
            addx -3
            addx 5
            addx -1
            addx -8
            addx 13
            addx 4
            noop
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx -35
            addx 1
            addx 24
            addx -19
            addx 1
            addx 16
            addx -11
            noop
            noop
            addx 21
            addx -15
            noop
            noop
            addx -3
            addx 9
            addx 1
            addx -3
            addx 8
            addx 1
            addx 5
            noop
            noop
            noop
            noop
            noop
            addx -36
            noop
            addx 1
            addx 7
            noop
            noop
            noop
            addx 2
            addx 6
            noop
            noop
            noop
            noop
            noop
            addx 1
            noop
            noop
            addx 7
            addx 1
            noop
            addx -13
            addx 13
            addx 7
            noop
            addx 1
            addx -33
            noop
            noop
            noop
            addx 2
            noop
            noop
            noop
            addx 8
            noop
            addx -1
            addx 2
            addx 1
            noop
            addx 17
            addx -9
            addx 1
            addx 1
            addx -3
            addx 11
            noop
            noop
            addx 1
            noop
            addx 1
            noop
            noop
            addx -13
            addx -19
            addx 1
            addx 3
            addx 26
            addx -30
            addx 12
            addx -1
            addx 3
            addx 1
            noop
            noop
            noop
            addx -9
            addx 18
            addx 1
            addx 2
            noop
            noop
            addx 9
            noop
            noop
            noop
            addx -1
            addx 2
            addx -37
            addx 1
            addx 3
            noop
            addx 15
            addx -21
            addx 22
            addx -6
            addx 1
            noop
            addx 2
            addx 1
            noop
            addx -10
            noop
            noop
            addx 20
            addx 1
            addx 2
            addx 2
            addx -6
            addx -11
            noop
            noop
            noop
		""".trimIndent()

        assertEquals(13140, day10Service.a(testInput))
    }

    @Test
    fun `day10b`() {
        val testInput = """
            addx 15
            addx -11
            addx 6
            addx -3
            addx 5
            addx -1
            addx -8
            addx 13
            addx 4
            noop
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx 5
            addx -1
            addx -35
            addx 1
            addx 24
            addx -19
            addx 1
            addx 16
            addx -11
            noop
            noop
            addx 21
            addx -15
            noop
            noop
            addx -3
            addx 9
            addx 1
            addx -3
            addx 8
            addx 1
            addx 5
            noop
            noop
            noop
            noop
            noop
            addx -36
            noop
            addx 1
            addx 7
            noop
            noop
            noop
            addx 2
            addx 6
            noop
            noop
            noop
            noop
            noop
            addx 1
            noop
            noop
            addx 7
            addx 1
            noop
            addx -13
            addx 13
            addx 7
            noop
            addx 1
            addx -33
            noop
            noop
            noop
            addx 2
            noop
            noop
            noop
            addx 8
            noop
            addx -1
            addx 2
            addx 1
            noop
            addx 17
            addx -9
            addx 1
            addx 1
            addx -3
            addx 11
            noop
            noop
            addx 1
            noop
            addx 1
            noop
            noop
            addx -13
            addx -19
            addx 1
            addx 3
            addx 26
            addx -30
            addx 12
            addx -1
            addx 3
            addx 1
            noop
            noop
            noop
            addx -9
            addx 18
            addx 1
            addx 2
            noop
            noop
            addx 9
            noop
            noop
            noop
            addx -1
            addx 2
            addx -37
            addx 1
            addx 3
            noop
            addx 15
            addx -21
            addx 22
            addx -6
            addx 1
            noop
            addx 2
            addx 1
            noop
            addx -10
            noop
            noop
            addx 20
            addx 1
            addx 2
            addx 2
            addx -6
            addx -11
            noop
            noop
            noop
		""".trimIndent()
        assertEquals(1, day10Service.b(testInput))
    }

    @Test
    fun `day11a`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day11Service.a(testInput))
    }

    @Test
    fun `day11b`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day11Service.b(testInput))
    }

    @Test
    fun `day12a`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day12Service.a(testInput))
    }

    @Test
    fun `day12b`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day12Service.b(testInput))
    }

    @Test
    fun `day13a`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day13Service.a(testInput))
    }

    @Test
    fun `day13b`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day13Service.b(testInput))
    }

    @Test
    fun `day14a`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day14Service.a(testInput))
    }

    @Test
    fun `day14b`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day14Service.b(testInput))
    }

    @Test
    fun `day15a`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day15Service.a(testInput))
    }

    @Test
    fun `day15b`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day15Service.b(testInput))
    }

    @Test
    fun `day16a`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day16Service.a(testInput))
    }

    @Test
    fun `day16b`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day16Service.b(testInput))
    }

    @Test
    fun `day17a`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day17Service.a(testInput))
    }

    @Test
    fun `day17b`() {
        val testInput = """
		""".trimIndent()
        assertEquals(1, day17Service.b(testInput))
    }
}
