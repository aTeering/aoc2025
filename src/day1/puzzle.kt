package day1

import java.io.File

fun main() {
    val inputFile = File("src/day1/input.txt")
    var position = 50
    var neutralCount = 0
    val minPos = 0
    val maxPos = 100

    inputFile.reader().use { reader ->
        reader.forEachLine { line ->
            val regex = Regex("\\d+|\\D+")
            val spittedLine = regex.findAll(line).map {
                it.groupValues.first()
            }.toList()

            val direction = spittedLine[0]
            val steps = spittedLine[1].toInt()

            if (direction == "R") {
                position = (position + steps) % maxPos
            }

            if (direction == "L") {
                position = (position - steps) % maxPos
                if (position < minPos) position += maxPos
            }

            if (position == minPos) {
                neutralCount += 1
            }

        }
    }

    println(neutralCount)
    println(position)
}