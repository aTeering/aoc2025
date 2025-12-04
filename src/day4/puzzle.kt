import java.io.File

fun main() {
    val grid = File("src/day4/input.txt").readLines()
    val rows = grid.size
    val cols = grid[0].length

    var accessibleCount = 0

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == '@') {
                val adjacentRolls = neighbors(r, c, rows, cols).count { (nr, nc) ->
                    grid[nr][nc] == '@'
                }
                if (adjacentRolls < 4) {
                    accessibleCount++
                }
            }
        }
    }

    println(accessibleCount)
}

fun neighbors(r: Int, c: Int, rows: Int, cols: Int): List<Pair<Int, Int>> {
    val result = mutableListOf<Pair<Int, Int>>()
    for (dr in -1..1) {
        for (dc in -1..1) {
            if (dr == 0 && dc == 0) continue
            val nr = r + dr
            val nc = c + dc
            if (nr in 0 until rows && nc in 0 until cols) {
                result.add(nr to nc)
            }
        }
    }
    return result
}
