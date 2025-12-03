package day3

import day2.hasDoubleSequenceA
import java.io.File

fun main() {
    val inputFile = File("src/day3/input.txt")
    var batteries = emptyArray<String>()
    var jolts = 0

    inputFile.reader().use { reader ->
        reader.forEachLine { line ->
            batteries += line
        }
    }

    for (battery in batteries) {
        val nwBattery = battery.dropLast(1)
        val maxNmbr = nwBattery.max()
        val batterySplittedFromMaxNmbr = splitFrom(battery, maxNmbr.toString())
        val secondMaxNmbr = batterySplittedFromMaxNmbr.last().max()
        val combined = "${maxNmbr}${secondMaxNmbr}"
        println(combined)
        jolts += combined.toInt()
    }

    println(jolts)
}

fun splitFrom(input: String, toSplitFrom: String): List<String> {
    val index = input.indexOf(toSplitFrom)

    return if (index != -1) {
        listOf(
            input.substring(0, index),        // before the '1'
            input.substring(index + 1)        // after the '1'
        )
    } else {
        listOf(input) // or handle "not found"
    }
}