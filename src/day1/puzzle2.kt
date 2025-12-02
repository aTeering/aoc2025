package day1

import java.io.File
import kotlin.math.abs

// This is not correct yet...
// Will try to come back to it in a later time
fun main() {
    val inputFile = File("src/day1/input.txt")
    var position = 50
    var neutralCount = 0
    val minPos = 0
    val maxPos = 99

    inputFile.reader().use { reader ->
        reader.forEachLine { line ->
            val regex = Regex("\\d+|\\D+")
            val spittedLine = regex.findAll(line).map {
                it.groupValues.first()
            }.toList()

            val direction = spittedLine[0]
            var steps = spittedLine[1].toInt()

            if (direction == "R") {
                while (steps > 0) {
                    position++
                    if (position >= maxPos) {
                        position = minPos
                        neutralCount++
                    }
                    steps -= 1
                }
            }

            if (direction == "L") {
                while (steps > 0) {
                    position--
                    if (position <= minPos) {
                        position = maxPos
                        neutralCount++
                    }
                    steps -= 1
                }
            }
            if (position == 0) neutralCount++
        }
    }

    println(neutralCount)
    println(position)
}