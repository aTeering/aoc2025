package day5

import java.io.File

fun main() {
    val input = File("src/day5/input.txt").readText()
    val parts = input.trim().split("\n\n")
    val ranges = parseRanges(parts[0].lines())
    val ids = parts[1].lines()

    var freshIds = 0

    for (id in ids) {
        if (isInAnyRange(id.toLong(), ranges)) freshIds++
    }

    println(freshIds)
}

fun parseRanges(lines: List<String>): List<LongRange> =
    lines.map { line ->
        val (start, end) = line.split("-").map { it.toLong() }
        start..end
    }

fun isInAnyRange(id: Long, ranges: List<LongRange>): Boolean = ranges.any { id in it }