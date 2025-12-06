package day5

import java.io.File

fun main() {
    val input = File("src/day5/input.txt").readText()
    val parts = input.trim().split("\n\n")
    val ranges = mergeRanges(parseRanges(parts[0].lines()))
    val count = ranges.sumOf { it.last - it.first + 1 }
    println(count)
}

fun mergeRanges(ranges: List<LongRange>): List<LongRange> {
    if (ranges.isEmpty()) return emptyList()

    val sorted = ranges.sortedBy { it.first }
    val merged = mutableListOf<LongRange>()

    var currentStart = sorted[0].first
    var currentEnd = sorted[0].last

    for (range in sorted.drop(1)) {
        if (range.first <= currentEnd + 1) {
            currentEnd = maxOf(currentEnd, range.last)
        } else {
            merged.add(currentStart..currentEnd)
            currentStart = range.first
            currentEnd = range.last
        }
    }

    merged.add(currentStart..currentEnd)

    return merged
}

