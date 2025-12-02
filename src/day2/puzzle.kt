package day2

import java.io.File

fun main() {
    val inputFile = File("src/day2/input.txt")
    var invalidIds = emptyArray<Long>()

    inputFile.reader().use { reader ->
        reader.forEachLine { line ->
            for (range in line.split(",").toTypedArray()) {
                val rangeArray = range.split("-")
                invalidIds += (rangeArray[0].toLong()..rangeArray[1].toLong()).filter { hasDoubleSequenceA(it) }
            }
        }
    }

    println(invalidIds.sum())
//    println(invalidIds.joinToString())
}

fun hasDoubleSequenceA(number: Long): Boolean {
    val s = number.toString()
    if (s.length % 2 != 0) return false  // must be even length

    val half = s.length / 2
    val a = s.substring(0, half)
    val b = s.substring(half)

    return a == b
}