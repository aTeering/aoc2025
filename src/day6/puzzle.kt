package day6

import java.io.File

fun main() {
    val lines = File("src/day6/input.txt").readLines()
    val grid = lines.map { it.trim().split(Regex("\\s+")) }
    val cols = grid[0].size

    var total: Long = 0

    for (c in 0 until cols) {
        var subTotal: Long? = null
        for (r in grid.indices) {
            val cell = grid[r][c].toLongOrNull()
            if (cell != null) {
                val operator = grid.last()[c]

                subTotal = when (operator) {
                    "+" -> (subTotal ?: 0) + cell
                    "-" -> (subTotal ?: 0) - cell
                    "*" -> (subTotal ?: 1) * cell
                    "/" -> if (subTotal != null && cell != 0L) subTotal / cell else subTotal
                    else -> subTotal ?: cell
                }
            }
        }
        total += subTotal ?: 0
    }

    println(total)
}
