package day2

import java.io.File

fun main() {
    val inputFile = File("src/day2/input.txt")
    var invalidIds = emptyArray<Long>()

    inputFile.reader().use { reader ->
        reader.forEachLine { line ->
            for (range in line.split(",").toTypedArray()) {
                val rangeArray = range.split("-")
                invalidIds += (rangeArray[0].toLong()..rangeArray[1].toLong()).filter { hasDoubleSequenceB(it) }
            }
        }
    }

    println(invalidIds.sum())

}

fun hasDoubleSequenceB(number: Long): Boolean {
    val s = number.toString()
    val n = s.length

    for (blockSize in 1..(n / 2)) {
        if (n % blockSize != 0) continue

        val repeats = n / blockSize
        if (repeats < 2) continue

        val block = s.substring(0, blockSize)
        val rebuilt = block.repeat(repeats)

        if (rebuilt == s) return true
    }

    return false
}