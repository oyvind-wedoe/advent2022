package com.oyvind.advent2022

import com.oyvind.advent2022.service.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

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

}

@Test
fun `day8a`() {

}

@Test
fun `day8b`() {

}

@Test
fun `day9a`() {

}

@Test
fun `day9b`() {

}

@Test
fun `day10a`() {

}

@Test
fun `day10b`() {

}

