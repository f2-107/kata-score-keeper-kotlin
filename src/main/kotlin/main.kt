fun main(args: Array<String>) {
    println("Horay, a new match.")
    print("Please enter name of team A: > ")
    val teamA = arrayOf(readLine()!!, "0")
    print("Please enter name of team B: > ")
    val teamB = arrayOf(readLine()!!, "0")

    println("\n\nMatch started. Yay.")
    showScoreBoard(teamA, teamB)

    do {
        println("____________________________________")
        println("Team A [${teamA[0]}] scores 1 (a1), 2 (a2), or 3 (a3) points.")
        println("Team B [${teamB[0]}] scores 1 (b1), 2 (b2), or 3 (b3) points.")
        print("Enter score code [or 'end' for finish the match]: ")
        val input = readLine()!!

        when (input) {
            "a1" -> score(teamA, 1)
            "a2" -> score(teamA, 2)
            "a3" -> score(teamA, 3)
            "b1" -> score(teamB, 1)
            "b2" -> score(teamB, 2)
            "b3" -> score(teamB, 3)
            "end" -> {
                println("\n\nMatch finished. Result:")
                showScoreBoard(teamA, teamB)
                break
            }
            else -> println("Error - Input invalid")
        }
        showScoreBoard(teamA, teamB)
    } while(true)
    println("\nThanks for using ScoreBoard :)")
}

fun score(team: Array<String>, score: Int) {
    team[1] = (team[1].toInt() + score).toString()
}

fun showScoreBoard(teamA: Array<String>, teamB: Array<String>) {
    val filler = 10
    val borderSymbol = "*"

    val score = "${teamA[1]}:${teamB[1]}"
    val totalLength = teamA[0].length + teamB[0].length + score.length + filler

    printTopBottomBorder(totalLength, borderSymbol)
    println("$borderSymbol ${teamA[0]} | $score | ${teamB[0]} $borderSymbol")
    printTopBottomBorder(totalLength, borderSymbol)
}

fun printTopBottomBorder(borderLength: Int, borderSymbol: String) {
    for (i in 0 until borderLength) print(borderSymbol)
    println()
}
