import java.io.File

fun main() {
    val lines = File("src/day4/input.txt").readLines()

    val rows = lines.size
    val cols = lines[0].length
    val grid = Array(rows) { r -> lines[r].toCharArray() }
    var totalRemoved = 0
    var round = 0

    while (true) {
        val toRemove = mutableListOf<Pair<Int, Int>>()

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == '@') {
                    val adjacent = neighbors(r, c, rows, cols).count { (nr, nc) -> grid[nr][nc] == '@' }
                    if (adjacent < 4) {
                        toRemove.add(r to c)
                    }
                }
            }
        }

        if (toRemove.isEmpty()) break

        round++
        for ((r, c) in toRemove) {
            grid[r][c] = 'x'
        }
        totalRemoved += toRemove.size
    }
    
    println("$totalRemoved")
}
