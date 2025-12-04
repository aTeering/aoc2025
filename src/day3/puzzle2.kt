package day3

import day2.hasDoubleSequenceA
import java.io.File

fun main() {
    val inputFile = File("src/day3/Input.txt")
    var batteries = emptyArray<String>()
    var jolts: Long = 0

    inputFile.reader().use { reader ->
        reader.forEachLine { line ->
            batteries += line
        }
    }

    for (battery in batteries) {
        var combined = ""
        var setBattery = battery
        for (i in 11 downTo 0 step 1) {
            val nwBattery = setBattery.dropLast(i)
            val maxNmbr = nwBattery.max()
            combined += "${maxNmbr}"
            // Reused spitFrom function from today's 1st puzzle
            setBattery = splitFrom(setBattery, maxNmbr.toString()).last()
        }
        jolts += combined.toLong()
    }

    println(jolts)
}